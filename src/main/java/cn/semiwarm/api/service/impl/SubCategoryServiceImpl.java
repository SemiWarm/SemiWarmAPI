package cn.semiwarm.api.service.impl;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.SubCategory;
import cn.semiwarm.api.mapper.SubCategoryMapper;
import cn.semiwarm.api.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 子类目服务类实现类
 * Created by alibct on 2017/4/6.
 */
@Service("subCategoryService")
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryMapper subCategoryMapper;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryMapper subCategoryMapper) {
        this.subCategoryMapper = subCategoryMapper;
    }

    public int addSubCategory(SubCategory subCategory) throws Exception {
        return subCategoryMapper.add(subCategory);
    }

    public int deleteSubCategory(SubCategory subCategory) throws Exception {
        return subCategoryMapper.delete(subCategory);
    }

    public int updateSubCategory(SubCategory subCategory) throws Exception {
        return subCategoryMapper.update(subCategory);
    }

    public BaseResponse<SubCategory> getSubCategoryById(Serializable id) throws Exception {
        BaseResponse<SubCategory> response = new BaseResponse<SubCategory>();
        SubCategory subCategory = subCategoryMapper.findById(id);
        if (null != subCategory) {
            response.setSuccess(1);
            response.setMessage("子类目信息");
            response.setData(subCategory);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<List<SubCategory>> getAllSubCategories() throws Exception {
        BaseResponse<List<SubCategory>> response = new BaseResponse<List<SubCategory>>();
        List<SubCategory> subCategories = subCategoryMapper.findAll();
        if (subCategories.size() > 0) {
            response.setSuccess(1);
            response.setMessage("子类目列表");
            response.setData(subCategories);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }
}
