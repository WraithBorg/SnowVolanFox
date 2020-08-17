package com.fox.business.client;

import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class StorageClient {
    private static final Logger log = LoggerFactory.getLogger(StorageClient.class);
    @Resource
    private RestTemplate restTemplate;

    public void deduct(String commodityCode, int orderCount) {
        System.out.println("business to storage " + RootContext.getXID());
        String url = "http://127.0.0.1:8081/storage/api/storage/deduct?commodityCode=" + commodityCode + "&count=" + orderCount;
        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception e) {
            log.error("deduct url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }
}
