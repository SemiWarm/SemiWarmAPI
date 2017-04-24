package cn.semiwarm.api.service;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.SubCategory;

import java.io.Serializable;
import java.util.List;

/**
 * 子类目服务类
 * Created by alibct on 2017/4/6.
 */
public interface SubCategoryService extends BaseService<SubCategory> {
    int addSubCategory(SubCategory subCategory) throws Exception;

    int deleteSubCategory(SubCategory subCategory) throws Exception;

    int updateSubCategory(SubCategory subCategory) throws Exception;

    BaseResponse<SubCategory> getSubCategoryById(Serializable id) throws Exception;

    BaseResponse<List<SubCategory>> getAllSubCategories() throws Exception;
}
