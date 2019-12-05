package com.example.commoncomponets.feignBack;

import com.example.commoncomponets.entity.provide.pm.SysAuthority;
import com.example.commoncomponets.enums.ResultEnum;
import com.example.commoncomponets.feignClient.provide.ProvideMicroService;
import com.example.commoncomponets.feignClient.consume.ConsumeUserMicroService;
import com.example.commoncomponets.utils.Result;
import com.example.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Component;

/**
 * @description: 断熔回调
 * @author: zhangshuai
 * @create: 2019-10-30 14:56
 */
@Component
public class EchoServiceFallback implements ConsumeUserMicroService,ProvideMicroService {

    @Override
    public Result saveSysAuthority(SysAuthority sysAuthority) {
        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"provide-"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }

    @Override
    public Result saveSysAuthority1(SysAuthority sysAuthority) {
        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"provide-"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }

    @Override
    public Result getUser() {
        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"provide-"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }

}
