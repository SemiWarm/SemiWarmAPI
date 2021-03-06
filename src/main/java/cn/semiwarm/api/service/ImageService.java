package cn.semiwarm.api.service;


import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.Image;

import java.io.Serializable;
import java.util.List;

/**
 * 图片服务类
 * Created by alibct on 2017/4/8.
 */
public interface ImageService extends BaseService<Image> {

    int addImage(Image image) throws Exception;

    int deleteImage(Image image) throws Exception;

    int updateImage(Image image) throws Exception;

    BaseResponse<Image> getImageById(Serializable id) throws Exception;

    BaseResponse<List<Image>> getAllImages() throws Exception;

    BaseResponse<List<Image>> getImagesByType(Serializable imageType) throws Exception;
}
