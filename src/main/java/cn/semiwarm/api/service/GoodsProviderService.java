package cn.semiwarm.api.service;


import cn.semiwarm.api.entity.GoodsProvider;

import java.util.List;

/**
 * GoodsProviderService
 * Created by alibct on 2017/5/10.
 */
public interface GoodsProviderService {

    int addGoodsProvider(GoodsProvider goodsProvider) throws Exception;

    List<GoodsProvider> getAllGoodsProvider() throws Exception;
}
