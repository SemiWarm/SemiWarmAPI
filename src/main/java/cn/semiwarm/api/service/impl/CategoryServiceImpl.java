package cn.semiwarm.api.service.impl;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.Category;
import cn.semiwarm.api.mapper.CategoryMapper;
import cn.semiwarm.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 类目服务类实现类
 * Created by alibct on 2017/4/6.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public int addCategory(Category category) throws Exception {
        return categoryMapper.add(category);
    }

    public int deleteCategory(Category category) throws Exception {
        return categoryMapper.delete(category);
    }

    public int updateCategory(Category category) throws Exception {
        return categoryMapper.update(category);
    }

    public BaseResponse<Category> getCategoryById(Serializable id) throws Exception {
        BaseResponse<Category> response = new BaseResponse<Category>();
        Category category = categoryMapper.findById(id);
        if (null != category) {
            response.setSuccess(1);
            response.setMessage("类目信息");
            response.setData(category);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<List<Category>> getAllCategories() throws Exception {
        BaseResponse<List<Category>> response = new BaseResponse<List<Category>>();
        List<Category> categories = categoryMapper.findAll();
        if (categories.size() > 0) {
            response.setSuccess(1);
            response.setMessage("类目列表");
            response.setData(categories);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }
}
