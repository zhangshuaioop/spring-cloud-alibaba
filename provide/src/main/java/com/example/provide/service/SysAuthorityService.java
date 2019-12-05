package com.example.provide.service;

import com.example.commoncomponets.base.BaseService;
import com.example.commoncomponets.entity.provide.pm.SysAuthority;
import com.example.commoncomponets.entity.provide.user.User;
import com.example.commoncomponets.feignClient.provide.ProvideMicroService;
import com.example.commoncomponets.utils.Result;
import com.example.commoncomponets.utils.ResultUtil;
import com.example.provide.mapper.pm.SysAuthorityMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

/**
 * @description: 权限信息
 * @author: zhangshuai
 * @create: 2019-11-08 10:27
 */
@Service
public class SysAuthorityService extends BaseService<SysAuthorityMapper, SysAuthority> implements ProvideMicroService {

    private final Logger logger = Logger.getLogger("SysAuthorityService");

    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    @Transactional
    public Result saveSysAuthority(SysAuthority sysAuthority){

        logger.info("保存权限信息开始");
        sysAuthorityMapper.insertSelective(sysAuthority);
        logger.info("保存权限信息结束");
        return ResultUtil.success();
    }


    @Transactional
    public Result saveSysAuthority1(SysAuthority sysAuthority){

        logger.info("保存权限信息开始");
        sysAuthorityMapper.insertSelective(sysAuthority);
        logger.info("保存权限信息结束");
        User user = null;
        user.setDept(user.getDept());

        return ResultUtil.success();
    }

    @Override
    public Result getUser() {
        User user = new User();
        user.setId(1l);
        user.setUsername("heheh");
        user.setEmail("23219849@qq.com");
        user.setDept("技术部Provide");
        return ResultUtil.success(user);
    }


}
