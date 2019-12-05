package com.example.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.example.commoncomponets.feignBack", "com.example.consume"})
@EnableFeignClients(basePackages = {"com.example.commoncomponets.feignClient"})
@EnableBinding({ Source.class, Sink.class })
@EnableAutoConfiguration
public class ConsumeApplication {

    public static void main(String[] args) {

        //设置ES NETTY冲突
        System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(ConsumeApplication.class, args);
    }

}
