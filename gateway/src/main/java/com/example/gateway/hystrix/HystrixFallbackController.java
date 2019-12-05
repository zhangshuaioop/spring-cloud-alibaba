package com.example.gateway.hystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 熔断器降级处理
 * @author: zhangshuai
 * @create: 2019-10-31 18:47
 */
@RestController
public class HystrixFallbackController {

    @RequestMapping("/hystrixFallback")
    public Map defaultFallback() {
        Map map = new HashMap();
        map.put("code", 1001);
        map.put("msg", "服务异常,请稍后再试。。");
        return map;
    }

}
