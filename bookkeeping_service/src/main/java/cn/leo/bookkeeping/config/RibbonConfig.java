package cn.leo.bookkeeping.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon 配置
 *
 * @author create by leo.zl on 2020/11/10
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule customerRule(){
        return new RoundRobinRule();
    }
}
