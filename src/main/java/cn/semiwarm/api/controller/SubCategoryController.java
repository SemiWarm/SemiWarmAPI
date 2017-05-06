package cn.semiwarm.api.controller;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.SubCategory;
import cn.semiwarm.api.service.impl.SubCategoryServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 子类目控制器
 * Created by alibct on 2017/4/6.
 */
@Controller
@RequestMapping(value = "/v1.0")
public class SubCategoryController {

    private final SubCategoryServiceImpl subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryServiceImpl subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    /**
     * 获取子类目列表
     *
     * @return 子类目列表
     * @throws Exception 异常
     */
    @RequestMapping(value = "/subCategories", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取子类目列表")
    @ResponseBody
    public BaseResponse<List<SubCategory>> getAllSubCategories() throws Exception {
        return subCategoryService.getAllSubCategories();
    }

    /**
     * 根据类目Id获取子类目列表
     *
     * @param categoryId 类目Id
     * @return 子类目列表
     * @throws Exception 异常
     */
    @RequestMapping(value = "/subCategories/categoryId/{categoryId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "根据类目Id获取子类目列表")
    @ResponseBody
    public BaseResponse<List<SubCategory>> getSubCategoriesByCategoryId(@PathVariable("categoryId") Integer categoryId) throws Exception {
        return subCategoryService.getSubCategoriesByCategoryId(categoryId);
    }
}
