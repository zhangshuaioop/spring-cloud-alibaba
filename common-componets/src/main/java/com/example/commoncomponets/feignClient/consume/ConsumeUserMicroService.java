package com.example.commoncomponets.feignClient.consume;

import com.example.commoncomponets.feignBack.EchoServiceFallback;
import com.example.commoncomponets.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户基本服务
 */
@FeignClient(name="service-consume",fallback = EchoServiceFallback.class)
public interface ConsumeUserMicroService {

    /**
     * 用户信息
     * @return
     */
    @RequestMapping(value = "/users/getUser",method=RequestMethod.GET)
    Result getUser();
}
