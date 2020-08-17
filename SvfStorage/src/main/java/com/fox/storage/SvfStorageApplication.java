package com.fox.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fox")
@MapperScan("com.fox.storage.mapper")
public class SvfStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(SvfStorageApplication.class, args);
    }

}
