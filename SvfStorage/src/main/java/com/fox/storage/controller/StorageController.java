package com.fox.storage.controller;

import com.fox.common.util.CustomUtil;
import com.fox.storage.entity.Storage;
import com.fox.storage.service.StorageService;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping(value = "/storageProc/api/deduct")
    public void deduct(@RequestParam String commodityCode, @RequestParam Integer count) throws SQLException {
        System.out.println("storage XID " + RootContext.getXID());
        storageService.deduct(commodityCode, count);
    }

    @GetMapping(value = "/storageProc/api/get/{id}")
    public Storage getById(@PathVariable("id") Integer id) {
        return storageService.get(id);
    }

    @GetMapping(value = "/storageProc/api/batch/update")
    public void batchUpdateCond() {
        try {
            storageService.batchUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/storageProc/api/batch/delete")
    public void batchDeleteCond() {
        try {
            storageService.batchDelete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/storageProc/api/test")
    public Object test() {
        return CustomUtil.ofMap("id", System.currentTimeMillis());
    }
}
