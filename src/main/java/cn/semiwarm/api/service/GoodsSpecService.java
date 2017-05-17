package cn.semiwarm.api.service;


import cn.semiwarm.api.entity.GoodsSpec;

import java.util.List;

/**
 * GoodsSpecService
 * Created by alibct on 2017/5/10.
 */
public interface GoodsSpecService {
    int addGoodsSpec(GoodsSpec goodsSpec) throws Exception;
    List<GoodsSpec> getAllGoodsSpec() throws Exception;
}
