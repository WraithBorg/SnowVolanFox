package com.fox.account.controller;


import com.fox.account.service.AccountService;
import com.fox.common.util.CustomUtil;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping
    public void debit(@RequestParam String userId, @RequestParam BigDecimal orderMoney) {
        System.out.println("account XID " + RootContext.getXID());
        accountService.debit(userId, orderMoney);
    }

    @GetMapping("/test")
    public Object test() {
        return CustomUtil.ofMap("id", System.currentTimeMillis());
    }
}
