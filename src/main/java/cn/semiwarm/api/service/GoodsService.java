package cn.semiwarm.api.service;


import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.Goods;

import java.io.Serializable;
import java.util.List;

/**
 * GoodsService
 * Created by alibct on 2017/5/10.
 */
public interface GoodsService {
    // 获取商品列表
    BaseResponse<List<Goods>> getAllGoods() throws Exception;

    // 根据商品所属子类目id获取商品列表
    BaseResponse<List<Goods>> getAllGoodsBySubCategoryId(Serializable id) throws Exception;

    // 根据商品供应商id获取商品列表
    BaseResponse<List<Goods>> getAllGoodsByProviderId(Serializable id) throws Exception;

    // 根据商品id获取商品信息
    BaseResponse<Goods> getGoodsById(Serializable id) throws Exception;

    // 搜索商品
    BaseResponse<List<Goods>> searchByTitleOrTagsOrDesc(String searchText) throws Exception;
}
