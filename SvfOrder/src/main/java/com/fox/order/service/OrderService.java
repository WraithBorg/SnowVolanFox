package com.fox.order.service;


import com.fox.order.client.AccountClient;
import com.fox.order.entity.Order;
import com.fox.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class OrderService {

    @Resource
    private AccountClient accountClient;
    @Resource
    private OrderMapper orderMapper;

    public void create(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderMapper.insert(order);

        accountClient.debit(userId, orderMoney);

    }
}
