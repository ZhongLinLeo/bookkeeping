package cn.leo.bookkeeping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

/**
 * @author leo.zl on 2020/6/5
 */
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class BookkeepingGatewayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookkeepingGatewayServiceApplication.class, args);
    }
}
