package cn.leo.bookkeeping.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * bookkeeping 启动类
 *
 * @author zl
 */
@SpringBootApplication
@EnableEurekaClient
public class BookkeepingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeepingServiceApplication.class, args);
    }

}
