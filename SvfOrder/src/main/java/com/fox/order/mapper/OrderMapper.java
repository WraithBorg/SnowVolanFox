package com.fox.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fox.order.entity.Order;

public interface OrderMapper extends BaseMapper<Order> {

    int insert(Order record);

}
