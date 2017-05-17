package cn.semiwarm.api.controller;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.Image;
import cn.semiwarm.api.service.impl.ImageServiceImpl;
import cn.semiwarm.api.utils.CommonFileUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

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
    public BaseResponse<List<Image>> getImagesByType(@PathVariable("imageType") String imageType) throws Exception {
        return imageService.getImagesByType(imageType);
    }


    /**
     * 上传用户头像
     *
     * @param request     请求
     * @param response    响应
     * @param userName    上传的用户名
     * @param uploadImage 上传的图片信息
     * @return 通用响应结果
     * @throws Exception 异常
     */
    @RequestMapping(value = "/{userName}/upload/image", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public BaseResponse<String> uploadImage(HttpServletRequest request, HttpServletResponse response, @PathVariable("userName") String userName, @RequestParam(value = "avatar", required = false) MultipartFile uploadImage) throws Exception {
        // 初始化请求结果
        BaseResponse<String> baseResponse = new BaseResponse<String>();

        try {

            if (!uploadImage.isEmpty()) {

                Image image = initUploadImage(request, response, uploadImage, userName);

                // 创建待上传的文件
                File uploadFile = new File(image.getImageRealPath());
                FileUtils.copyInputStreamToFile(uploadImage.getInputStream(), uploadFile);

                // 将图片持久化到数据库中
                int result = imageService.addImage(image);

                if (result > 0) {
                    baseResponse.setSuccess(1);
                    baseResponse.setMessage("图片上传成功!");
                    baseResponse.setData(image.getImageAccessPath());
                } else {
                    baseResponse.setSuccess(0);
                    baseResponse.setMessage("图片上传异常!");
                    baseResponse.setData("");
                }


            } else {
                baseResponse.setSuccess(-1);
                baseResponse.setMessage("请先选择需要上传的图片!");
                baseResponse.setData("");
            }

        } catch (Exception e) {
            baseResponse.setSuccess(0);
            baseResponse.setMessage("图片上传失败!");
            baseResponse.setData("");
        }

        return baseResponse;
    }


    /**
     * 初始化从客户端获取的图片信息
     *
     * @param request  请求
     * @param response 响应
     * @param image    处理的图片
     * @param userName 上传的用户名
     * @return 初始化的图片信息
     */
    private Image initUploadImage(HttpServletRequest request, HttpServletResponse response, MultipartFile image, String userName) {

        // 设置头信息
        response.setHeader("Content-Type", "text/html");

        // 根据图片类型初始化上传路径
        String realPath = "/file/upload/images/UserAvatar".concat("/");
        // 上传的路径
        String uploadPath = request.getSession().getServletContext().getRealPath(realPath);
        // 根据上传路径初始化File对象
        File uploadDir = new File(uploadPath);
        // 如果文件夹不存在则创建文件夹
        if (!uploadDir.exists()) {
            boolean result = uploadDir.mkdirs();
            if (result) {
                System.out.println("文件夹创建成功!");
            } else {
                System.out.println("文件夹已存在!");
            }
        }

        Image result = new Image();

        // 图片原始名称
        String imageOriginalName = image.getOriginalFilename();
        // 图片扩展名
        String imageExtensionName = CommonFileUtils.getExtensionName(imageOriginalName);
        // 图片存储名称
        String imageName = UUID.randomUUID().toString().concat(".").concat(imageExtensionName);
        // 图片物理路径
        String imageRealPath = uploadPath.concat(imageName);
        // 图片访问路径
        String imageAccessPath = "http://www.semiwarm.cn/admin/upload/images/UserAvatar".concat("/").concat(imageName);
        // 图片大小
        String imageSize = CommonFileUtils.formatFileSizeToString(image.getSize());
        // 图片上传日期
        // 数据库中有一个当前日期类型

        result.setImageUuid(UUID.randomUUID().toString());
        result.setImageOriginalName(imageOriginalName);
        result.setImageName(imageName);
        result.setImageExtensionName(imageExtensionName);
        result.setImageRealPath(imageRealPath);
        result.setImageAccessPath(imageAccessPath);
        result.setImageSize(imageSize);
        result.setImageType("UserAvatar");
        result.setUploadedBy(userName);
        result.setStatus(true);

        return result;

    }
}
