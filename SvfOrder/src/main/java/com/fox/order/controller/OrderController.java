package com.fox.order.controller;

import com.fox.common.util.CustomUtil;
import com.fox.order.service.OrderService;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/orderProc/api/debit")
    public void debit(@RequestParam String userId, @RequestParam String commodityCode, @RequestParam Integer count) {
        System.out.println("order XID " + RootContext.getXID());
        orderService.create(userId, commodityCode, count);
    }
    @GetMapping("/orderProc/api/test")
    public Object test() {
        return CustomUtil.ofMap("id", System.currentTimeMillis());
    }
}
