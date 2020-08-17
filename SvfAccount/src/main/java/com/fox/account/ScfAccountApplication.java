package com.fox.account;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fox")
@MapperScan("com.fox.account.mapper")
public class ScfAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScfAccountApplication.class, args);
    }
}


