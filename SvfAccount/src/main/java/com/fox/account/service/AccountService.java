package com.fox.account.service;


import com.fox.account.entity.Account;
import com.fox.account.mapper.AccountMapper;
import com.fox.common.util.CustomUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Resource
    private AccountMapper accountMapper;

    public void debit(String userId, BigDecimal num) {
        Account account = accountMapper.selectByMap(CustomUtil.ofMap(Account.t.user_id, userId)).get(0);
        account.setMoney(account.getMoney().subtract(num));
        accountMapper.updateById(account);
        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }

}
