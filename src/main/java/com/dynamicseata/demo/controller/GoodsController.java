package com.dynamicseata.demo.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dynamicseata.demo.mapper.goodsdb.GoodsMapper;
import com.dynamicseata.demo.pojo.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";

    @Resource
    private GoodsMapper goodsMapper;

    //更新商品库存 参数:商品id
    @RequestMapping("/goodsstock/{goodsId}/{count}")
    @ResponseBody
    @DS("goodsdb")
    public String goodsStock(@PathVariable Long goodsId,
                            @PathVariable int count) {
         int res = goodsMapper.updateGoodsStock(goodsId,count);
         System.out.println("res:"+res);

         if (res>0) {
             return SUCCESS;
         } else {
             return FAIL;
         }
    }

    //商品详情 参数:商品id
    @GetMapping("/goodsinfo")
    @ResponseBody
    @DS("goodsdb")
    public Goods goodsInfo(@RequestParam(value="goodsid",required = true,defaultValue = "0") Long goodsId) {
        Goods goods = goodsMapper.selectOneGoods(goodsId);
        return goods;
    }

}
