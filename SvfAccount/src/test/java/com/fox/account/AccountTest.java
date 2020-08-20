package com.fox.account;

import com.alibaba.fastjson.JSON;
import com.fox.account.entity.Account;
import com.fox.account.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountTest {
    @Resource
    private AccountMapper accountMapper;

    @Test
    public void testJDBC() {
        List<Account> accounts = accountMapper.selectList(null);
        System.out.println(JSON.toJSONString(accounts));
    }
}
