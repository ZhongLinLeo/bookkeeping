package cn.leo.bookkeeping.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * bookkeeping 用户服务启动类
 *
 * @author zl
 */
@EnableEurekaClient
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class BookkeepingUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeepingUserServiceApplication.class, args);
    }

}


