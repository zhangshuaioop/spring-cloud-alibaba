package com.example.commoncomponets.feignClient.provide;

import com.example.commoncomponets.entity.provide.pm.SysAuthority;
import com.example.commoncomponets.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * provie服务
 */
//@FeignClient(name="service-provide",fallback = EchoServiceFallback.class)
@FeignClient(name="service-provide")
public interface ProvideMicroService {

    /**
     * 用户信息保存
     * @return
     */
    @RequestMapping(value = "/sysAuthority/saveSysAuthority",method=RequestMethod.POST)
    Result saveSysAuthority(@RequestBody SysAuthority sysAuthority);

    @RequestMapping(value = "/sysAuthority/saveSysAuthority1",method=RequestMethod.POST)
    Result saveSysAuthority1(@RequestBody SysAuthority sysAuthority);


    /**
     * 用户信息
     * @return
     */
    @RequestMapping(value = "/user/getUser",method=RequestMethod.GET)
    Result getUser();

}
