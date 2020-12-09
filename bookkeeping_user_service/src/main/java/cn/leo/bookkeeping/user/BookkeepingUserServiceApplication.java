package cn.leo.bookkeeping.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * bookkeeping 用户服务 启动类
 *
 * @author zl
 */
@SpringBootApplication(scanBasePackages = "cn.leo.bookkeeping",exclude = {JacksonAutoConfiguration.class})
@EnableFeignClients("cn.leo.bookkeeping.api")
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.leo.bookkeeping.user.dao")
public class BookkeepingUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeepingUserServiceApplication.class, args);
    }

}


