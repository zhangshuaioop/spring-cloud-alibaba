package com.example.provide;

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
@ComponentScan(basePackages = {"com.example.commoncomponets.feignBack", "com.example.provide"})
@EnableFeignClients(basePackages = {"com.example.commoncomponets.feignClient"})
@EnableBinding({ Source.class, Sink.class })
@EnableAutoConfiguration
public class ProvideApplication {

    public static void main(String[] args) throws InterruptedException {

        //设置ES NETTY冲突
        System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(ProvideApplication.class, args);

//        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProvideApplication.class, args);
//        while(true) {
//            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
//            String userName = applicationContext.getEnvironment().getProperty("provide.name");
//            System.err.println("provide name :" + userName);
//            TimeUnit.SECONDS.sleep(1);
//        }


    }

}
