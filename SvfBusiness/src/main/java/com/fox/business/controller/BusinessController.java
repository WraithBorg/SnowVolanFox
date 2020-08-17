package com.fox.business.controller;


import com.fox.business.service.BusinessService;
import com.fox.common.util.CustomUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/api/business")
@RestController
public class BusinessController {

    @Resource
    private BusinessService businessService;

    /**
     * 购买下单，模拟全局事务提交
     */
    @RequestMapping("/purchase/commit")
    public Boolean purchaseCommit(HttpServletRequest request) {
        businessService.purchase("1001", "2001", 1);
        return true;
    }

    /**
     * 购买下单，模拟全局事务回滚
     */
    @RequestMapping("/purchase/rollback")
    public Boolean purchaseRollback() {
        try {
            businessService.purchase("1002", "2001", 1);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @GetMapping("/test")
    public Object test() {
        return CustomUtil.ofMap("id", System.currentTimeMillis());
    }
}
