package com.dynamicseata.demo.mapper.goodsdb;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dynamicseata.demo.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GoodsMapper {
    //@DS("goodsdb")
    Goods selectOneGoods(Long goodsId);
    //@DS("goodsdb")
    int updateGoodsStock(@Param("goodsId") Long goodsId, @Param("changeAmount") int changeAmount);
}
