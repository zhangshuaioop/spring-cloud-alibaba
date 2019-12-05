package com.example.message.config;

import org.apache.dubbo.config.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: dubbo配置
 * @author: zhangshuai
 * @create: 2019-10-31 21:31
 */
@Configuration
public class DubboConfig {
    /**
     * 消费者配置不主动监听服务
     *
     * @return
     */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setCheck(false);
        consumerConfig.setTimeout(4000);
        return consumerConfig;
    }

}
