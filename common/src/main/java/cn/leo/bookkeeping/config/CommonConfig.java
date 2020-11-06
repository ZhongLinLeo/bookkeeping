package cn.leo.bookkeeping.config;

import cn.leo.bookkeeping.util.EncryptUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leo.zl on 2020/6/4
 */
@Configuration
public class CommonConfig {

    @Bean
    @ConditionalOnBean(EncryptUtils.class)
    public EncryptUtils encryptUtils() {
        return EncryptUtils.getInstance();
    }
}
