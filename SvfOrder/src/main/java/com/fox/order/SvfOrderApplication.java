package com.fox.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fox")
@MapperScan("com.fox.order")
public class SvfOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SvfOrderApplication.class, args);
    }

}
