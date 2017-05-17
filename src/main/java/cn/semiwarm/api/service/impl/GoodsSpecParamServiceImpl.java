package cn.semiwarm.api.service.impl;


import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.GoodsSpecParam;
import cn.semiwarm.api.mapper.GoodsSpecParamMapper;
import cn.semiwarm.api.service.GoodsSpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alibct on 2017/5/10.
 */
@Service("goodsSpecParamService")
public class GoodsSpecParamServiceImpl implements GoodsSpecParamService {

    private final GoodsSpecParamMapper goodsSpecParamMapper;

    @Autowired
    public GoodsSpecParamServiceImpl(GoodsSpecParamMapper goodsSpecParamMapper) {
        this.goodsSpecParamMapper = goodsSpecParamMapper;
    }

    public BaseResponse<List<GoodsSpecParam>> getAllSpecParamsByGoodsId(Serializable id) throws Exception {
        BaseResponse<List<GoodsSpecParam>> response = new BaseResponse<List<GoodsSpecParam>>();
        List<GoodsSpecParam> goodsSpecParams = goodsSpecParamMapper.findByGoodsId(id);
        if (null != goodsSpecParams) {
            response.setSuccess(1);
            response.setMessage("商品规格参数");
            response.setData(goodsSpecParams);
        } else {
            response.setSuccess(0);
            response.setMessage("没有数据");
            response.setData(null);
        }
        return response;
    }
}
