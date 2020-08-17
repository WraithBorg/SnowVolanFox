package com.fox.business.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class OrderClient {
    private static final Logger log = LoggerFactory.getLogger(OrderClient.class);
    @Resource
    private RestTemplate restTemplate;

    public void create(String userId, String commodityCode, int orderCount) {
        String url = "http://127.0.0.1:8082/order/api/order/debit?userId=" + userId + "&commodityCode=" + commodityCode + "&count=" + orderCount;
        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception e) {
            log.error("create url {} ,error:", url);
            throw new RuntimeException();
        }
    }
}
