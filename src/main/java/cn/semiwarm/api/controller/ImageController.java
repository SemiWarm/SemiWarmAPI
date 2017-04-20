package cn.semiwarm.api.controller;

import cn.semiwarm.api.entity.Image;
import cn.semiwarm.api.service.impl.ImageServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 图片控制器
 * Created by alibct on 2017/4/16.
 */
@Controller
@RequestMapping(value = "/v1.0")
public class ImageController {

    private final ImageServiceImpl imageService;

    @Autowired
    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    /**
     * 根据图片类型获取图片列表
     *
     * @param imageType 图片类型
     * @return 图片列表
     * @throws Exception 异常
     */
    @RequestMapping(value = "/{imageType}/images", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "根据图片类型获取图片列表")
    @ResponseBody
    public List<Image> findImagesByType(@PathVariable("imageType") String imageType) throws Exception {
        return imageService.findImageByImageType(imageType);
    }
}
