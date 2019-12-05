package com.example.provide.service;

import com.example.commoncomponets.entity.provide.pm.SysAuthority;
import com.example.commoncomponets.entity.provide.user.User;
import com.example.commoncomponets.feignClient.provide.ProvideMicroService;
import com.example.commoncomponets.utils.Result;
import com.example.commoncomponets.utils.ResultUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @description: 用户基础服务
 * @author: zhangshuai
 * @create: 2018-10-25 14:59
 */
@Service
public class UserService implements ProvideMicroService {


    @Override
    public Result saveSysAuthority(SysAuthority sysAuthority) {
        return null;
    }

    @Override
    public Result saveSysAuthority1(SysAuthority sysAuthority) {
        return null;
    }

    /**
     * 用户信息
     *
     * @return
     */
    @Override
    public Result getUser() {
        User user = new User();
        user.setId(1l);
        user.setUsername("heheh");
        user.setEmail("23219849@qq.com");
        user.setDept("技术部");
        return ResultUtil.success(user);
    }


    /**
     * MQ消费
     * @param receiveMsg
     */
    @StreamListener("input")
    public void receiveInput(String receiveMsg) {
        System.out.println("消费成功: " + receiveMsg);
    }


}
