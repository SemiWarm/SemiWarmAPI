package cn.semiwarm.api.mapper;


import cn.semiwarm.api.entity.Goods;

import java.io.Serializable;
import java.util.List;

/**
 * 商品Mapper
 * Created by alibct on 2017/5/10.
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    int add(Goods goods);

    int delete(Goods goods);

    int update(Goods goods);

    Goods findById(Serializable id);

    List<Goods> findAll();

    List<Goods> findBySubCategoryId(Serializable id);

    List<Goods> findByProviderId(Serializable id);

    List<Goods> findByTitleOrTagsOrDesc(Serializable id);
}
