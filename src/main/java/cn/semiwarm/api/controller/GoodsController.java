package cn.semiwarm.api.controller;

import cn.semiwarm.api.entity.BaseResponse;
import cn.semiwarm.api.entity.Goods;
import cn.semiwarm.api.entity.GoodsSpecParam;
import cn.semiwarm.api.service.impl.GoodsServiceImpl;
import cn.semiwarm.api.service.impl.GoodsSpecParamServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * GoodsController
 * Created by alibct on 2017/5/17.
 */
@Controller
@RequestMapping(value = "/v1.0")
public class GoodsController {

    private final GoodsServiceImpl goodsService;
    private final GoodsSpecParamServiceImpl goodsSpecParamService;

    @Autowired
    public GoodsController(GoodsServiceImpl goodsService, GoodsSpecParamServiceImpl goodsSpecParamService) {
        this.goodsService = goodsService;
        this.goodsSpecParamService = goodsSpecParamService;
    }

    /**
     * 获取商品列表
     *
     * @return 所有商品
     * @throws Exception 异常
     */
    @RequestMapping(value = "/goods", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "获取商品列表")
    @ResponseBody
    public BaseResponse<List<Goods>> getAllGoods() throws Exception {
        return goodsService.getAllGoods();
    }

    /**
     * 根据商品id获取商品信息
     *
     * @param id 商品id
     * @return 商品信息
     * @throws Exception 异常
     */
    @RequestMapping(value = "/goodsId/{id}/goods", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "根据商品id获取商品信息")
    @ResponseBody
    public BaseResponse<Goods> getGoodsById(@PathVariable("id") Long id) throws Exception {
        return goodsService.getGoodsById(id);
    }

    /**
     * 根据商品所属子类目id获取商品列表
     *
     * @param id 商品所属子类目id
     * @return 商品列表
     * @throws Exception 异常
     */
    @RequestMapping(value = "/subCategoryId/{id}/goods", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "根据商品所属子类目id获取商品列表")
    @ResponseBody
    public BaseResponse<List<Goods>> getAllGoodsBySubCategoryId(@PathVariable("id") Integer id) throws Exception {
        return goodsService.getAllGoodsBySubCategoryId(id);
    }

    /**
     * 根据商品供应商id获取商品列表
     *
     * @param id 商品供应商id
     * @return 商品列表
     * @throws Exception 异常
     */
    @RequestMapping(value = "/providerId/{id}/goods", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "根据商品供应商id获取商品列表")
    @ResponseBody
    public BaseResponse<List<Goods>> getAllGoodsByProviderId(@PathVariable("id") Long id) throws Exception {
        return goodsService.getAllGoodsByProviderId(id);
    }

    /**
     * 根据商品标题、商品标签和商品描述进行模糊查询
     *
     * @param searchText 查询文本
     * @return 商品列表
     * @throws Exception 异常
     */
    @RequestMapping(value = "/search/{searchText}/goods", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "搜索商品")
    @ResponseBody
    public BaseResponse<List<Goods>> searchByTitleOrTagsOrDesc(@PathVariable("searchText") String searchText) throws Exception {
        return goodsService.searchByTitleOrTagsOrDesc(searchText);
    }

    /**
     * 根据商品id获取商品规格参数
     *
     * @param id 商品id
     * @return 商品规格参数列表
     * @throws Exception 异常
     */
    @RequestMapping(value = "/goodsId/{id}/specParams", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ApiOperation(value = "根据商品id获取商品规格参数")
    @ResponseBody
    public BaseResponse<List<GoodsSpecParam>> getAllSpecParamsByGoodsId(@PathVariable("id") Long id) throws Exception {
        return goodsSpecParamService.getAllSpecParamsByGoodsId(id);
    }
}
