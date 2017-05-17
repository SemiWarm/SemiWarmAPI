package cn.semiwarm.api.service.impl;


import cn.semiwarm.api.entity.GoodsSpec;
import cn.semiwarm.api.mapper.GoodsSpecMapper;
import cn.semiwarm.api.service.GoodsSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * GoodsSpecServiceImpl
 * Created by alibct on 2017/5/10.
 */

@Service("goodsSpecService")
public class GoodsSpecServiceImpl implements GoodsSpecService {

    private final GoodsSpecMapper goodsSpecMapper;

    @Autowired
    public GoodsSpecServiceImpl(GoodsSpecMapper goodsSpecMapper) {
        this.goodsSpecMapper = goodsSpecMapper;
    }

    public int addGoodsSpec(GoodsSpec goodsSpec) throws Exception {
        Date date = new Date();
        goodsSpec.setSpecId(date.getTime());
        return goodsSpecMapper.add(goodsSpec);
    }

    public List<GoodsSpec> getAllGoodsSpec() throws Exception {
        return goodsSpecMapper.findAll();
    }
}
