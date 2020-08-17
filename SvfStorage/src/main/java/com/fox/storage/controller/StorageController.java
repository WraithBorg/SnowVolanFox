package com.fox.storage.controller;

import com.fox.common.util.CustomUtil;
import com.fox.storage.entity.Storage;
import com.fox.storage.service.StorageService;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;

@RequestMapping("/api/storage")
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping(value = "/deduct")
    public void deduct(@RequestParam String commodityCode, @RequestParam Integer count) throws SQLException {
        System.out.println("storage XID " + RootContext.getXID());
        storageService.deduct(commodityCode, count);
    }

    @GetMapping(value = "/get/{id}")
    public Storage getById(@PathVariable("id") Integer id) {
        return storageService.get(id);
    }

    @GetMapping(value = "/batch/update")
    public void batchUpdateCond() {
        try {
            storageService.batchUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/batch/delete")
    public void batchDeleteCond() {
        try {
            storageService.batchDelete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/test")
    public Object test() {
        return CustomUtil.ofMap("id", System.currentTimeMillis());
    }
}
