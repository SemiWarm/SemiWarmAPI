package cn.semiwarm.api.service;


import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.GoodsSpecParam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alibct on 2017/5/10.
 */
public interface GoodsSpecParamService {
    // 根据商品id获取商品规格参数
    BaseResponse<List<GoodsSpecParam>> getAllSpecParamsByGoodsId(Serializable id) throws Exception;
}
