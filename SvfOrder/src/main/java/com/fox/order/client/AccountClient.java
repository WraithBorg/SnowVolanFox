package com.fox.order.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;


@Component
public class AccountClient {
    private static final Logger log = LoggerFactory.getLogger(AccountClient.class);
    @Resource
    private RestTemplate restTemplate;

    public void debit(String userId, BigDecimal orderMoney) {
        String url = "http://127.0.0.1:8083?userId=" + userId + "&orderMoney=" + orderMoney;
        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception e) {
            log.error("debit url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }
}
