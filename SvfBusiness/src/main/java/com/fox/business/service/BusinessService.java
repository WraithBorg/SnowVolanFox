package com.fox.business.service;

import com.fox.business.client.OrderClient;
import com.fox.business.client.StorageClient;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

    @Resource
    private StorageClient storageClient;
    @Resource
    private OrderClient orderClient;

    /**
     * 减库存，下订单
     */
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount) {
        LOGGER.info("purchase begin ... xid: " + RootContext.getXID());
        storageClient.deduct(commodityCode, orderCount);
        orderClient.create(userId, commodityCode, orderCount);
    }
}
