package cn.semiwarm.api.service.impl;


import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.Goods;
import cn.semiwarm.api.mapper.GoodsMapper;
import cn.semiwarm.api.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * GoodsServiceImpl
 * Created by alibct on 2017/5/10.
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }


    public BaseResponse<List<Goods>> getAllGoods() throws Exception {
        BaseResponse<List<Goods>> response = new BaseResponse<List<Goods>>();
        List<Goods> goodsList = goodsMapper.findAll();
        if (null != goodsList) {
            response.setSuccess(1);
            response.setMessage("商品列表");
            response.setData(goodsList);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<List<Goods>> getAllGoodsBySubCategoryId(Serializable id) throws Exception {
        BaseResponse<List<Goods>> response = new BaseResponse<List<Goods>>();
        List<Goods> goodsList = goodsMapper.findBySubCategoryId(id);
        if (null != goodsList) {
            response.setSuccess(1);
            response.setMessage("子类目商品列表");
            response.setData(goodsList);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<List<Goods>> getAllGoodsByProviderId(Serializable id) throws Exception {
        BaseResponse<List<Goods>> response = new BaseResponse<List<Goods>>();
        List<Goods> goodsList = goodsMapper.findByProviderId(id);
        if (null != goodsList) {
            response.setSuccess(1);
            response.setMessage("商品供应商商品列表");
            response.setData(goodsList);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<Goods> getGoodsById(Serializable id) throws Exception {
        BaseResponse<Goods> response = new BaseResponse<Goods>();
        Goods goods = goodsMapper.findById(id);
        if (null != goods) {
            response.setSuccess(1);
            response.setMessage("商品信息");
            response.setData(goods);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }

    public BaseResponse<List<Goods>> searchByTitleOrTagsOrDesc(String searchText) throws Exception {
        BaseResponse<List<Goods>> response = new BaseResponse<List<Goods>>();
        List<Goods> goodsList = goodsMapper.findByTitleOrTagsOrDesc(searchText);
        if (null != goodsList) {
            response.setSuccess(1);
            response.setMessage("搜索结果");
            response.setData(goodsList);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }
}
