package cn.semiwarm.api.mapper;


import cn.semiwarm.api.entity.GoodsSpecParam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alibct on 2017/5/10.
 */
public interface GoodsSpecParamMapper extends BaseMapper<GoodsSpecParam> {

    int add(GoodsSpecParam goodsSpecParam);

    int delete(GoodsSpecParam goodsSpecParam);

    int update(GoodsSpecParam goodsSpecParam);

    GoodsSpecParam findById(Serializable id);

    List<GoodsSpecParam> findAll();

    List<GoodsSpecParam> findByGoodsId(Serializable id);
}
