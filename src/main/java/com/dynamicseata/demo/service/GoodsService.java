package com.dynamicseata.demo.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dynamicseata.demo.mapper.goodsdb.GoodsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Service
public class GoodsService {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";

    @Resource
    private GoodsMapper goodsMapper;

    //@Transactional
    @DS("goodsdb")
    public String goodsStock(Long goodsId, int count) {



        int res = goodsMapper.updateGoodsStock(goodsId,count);
        System.out.println("res:"+res);
        //return FAIL;
        //int divide = 0;
        //int resul = 100 / divide;

        if (res>0) {
            return SUCCESS;
        } else {
            return FAIL;
        }

    }

}
