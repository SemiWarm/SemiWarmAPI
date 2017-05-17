package cn.semiwarm.api.mapper;


import cn.semiwarm.api.entity.GoodsProvider;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alibct on 2017/5/10.
 */
public interface GoodsProviderMapper extends BaseMapper<GoodsProvider> {

    int add(GoodsProvider goodsProvider);

    int delete(GoodsProvider goodsProvider);

    int update(GoodsProvider goodsProvider);

    GoodsProvider findById(Serializable id);

    List<GoodsProvider> findAll();
}
