package cn.leo.bookkeeping.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author leo.zl on 2020/3/29
 */
@SpringBootApplication
@EnableEurekaServer
public class BookkeepingEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeepingEurekaApplication.class, args);
    }

}
