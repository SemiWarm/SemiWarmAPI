package cn.semiwarm.api.controller;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.Category;
import cn.semiwarm.api.service.impl.CategoryServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类目控制器
 * Created by alibct on 2017/4/6.
 */
@Controller
@RequestMapping(value = "/v1.0")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    /**
     * 获取类目列表
     *
     * @return 类目列表
     * @throws Exception 异常
     */
    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取类目列表")
    @ResponseBody
    public BaseResponse<List<Category>> getAllCategories() throws Exception {
        return categoryService.getAllCategories();
    }
}
