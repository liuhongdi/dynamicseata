package com.dynamicseata.demo.mapper.orderdb;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dynamicseata.demo.pojo.Goods;
import com.dynamicseata.demo.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper {
    Order selectOneOrder(Long orderId);
    int insertOneOrder(Order order);
}
