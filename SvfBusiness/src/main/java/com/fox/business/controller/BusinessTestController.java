package com.fox.business.controller;

import com.fox.business.service.BusinessTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 分布式事物测试
 */
@RestController
public class BusinessTestController {
    @Resource
    private BusinessTestService businessTestService;
    /**
     * 购买下单，模拟全局事务提交
     */
    @RequestMapping("/businessProc/api/purchase/commit/test")
    public Boolean purchaseCommit(HttpServletRequest request) {
        businessTestService.purchase("1001", "2001", 1);
        return true;
    }
    /**
     * 购买下单，模拟全局事务提交
     */
    @RequestMapping("/businessProc/api/purchase/commit/test/purchase_WithOut_Global_Transaction")
    public Boolean purchase_WithOut_Global_Transaction(HttpServletRequest request) {
        businessTestService.purchase_WithOut_Global_Transaction("1001", "2001", 1);
        return true;
    }
    /**
     * 购买下单，模拟全局事务提交
     */
    @RequestMapping("/businessProc/api/purchase/commit/test/purchase_WithOut_Transaction")
    public Boolean purchase_WithOut_Transaction(HttpServletRequest request) {
        businessTestService.purchase_WithOut_Transaction("1001", "2001", 1);
        return true;
    }

}
