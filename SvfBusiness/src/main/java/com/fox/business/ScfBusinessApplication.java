package com.fox.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.fox", exclude = DataSourceAutoConfiguration.class)
public class ScfBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScfBusinessApplication.class, args);
    }
}
