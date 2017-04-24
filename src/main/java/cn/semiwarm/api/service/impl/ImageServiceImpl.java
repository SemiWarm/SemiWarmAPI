package cn.semiwarm.api.service.impl;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.Image;
import cn.semiwarm.api.mapper.ImageMapper;
import cn.semiwarm.api.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 图片服务类实现类
 * Created by alibct on 2017/4/8.
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {

    private final ImageMapper imageMapper;

    @Autowired
    public ImageServiceImpl(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public int addImage(Image image) throws Exception {
        return imageMapper.add(image);
    }

    public int deleteImage(Image image) throws Exception {
        return imageMapper.delete(image);
    }

    public int updateImage(Image image) throws Exception {
        return imageMapper.update(image);
    }

    public BaseResponse<Image> getImageById(Serializable id) throws Exception {
        BaseResponse<Image> response = new BaseResponse<Image>();
        Image image = imageMapper.findById(id);
        if (null != image) {
            response.setSuccess(1);
            response.setMessage("图片信息");
            response.setData(image);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<List<Image>> getAllImages() throws Exception {
        BaseResponse<List<Image>> response = new BaseResponse<List<Image>>();
        List<Image> images = imageMapper.findAll();
        if (images.size() > 0) {
            response.setSuccess(1);
            response.setMessage("图片列表");
            response.setData(images);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<List<Image>> getImagesByType(Serializable imageType) throws Exception {
        BaseResponse<List<Image>> response = new BaseResponse<List<Image>>();
        List<Image> images = imageMapper.findByImageType(imageType);
        if (images.size() > 0) {
            response.setSuccess(1);
            response.setMessage("图片列表");
            response.setData(images);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }
}
