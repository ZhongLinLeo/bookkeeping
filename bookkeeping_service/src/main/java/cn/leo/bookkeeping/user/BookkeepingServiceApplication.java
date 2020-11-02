package cn.leo.bookkeeping.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * bookkeeping 启动类
 *
 * @author zl
 */
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients("cn.leo")
@MapperScan(basePackages = {"cn.leo.bookkeeping.user"})
public class BookkeepingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeepingServiceApplication.class, args);
    }

}


