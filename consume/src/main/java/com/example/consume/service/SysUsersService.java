package com.example.consume.service;

import com.example.commoncomponets.base.BaseService;
import com.example.commoncomponets.entity.consume.pm.SysUsers;
import com.example.commoncomponets.entity.provide.pm.SysAuthority;
import com.example.commoncomponets.feignClient.provide.ProvideMicroService;
import com.example.commoncomponets.utils.Result;
import com.example.commoncomponets.utils.ResultUtil;
import com.example.consume.mapper.pm.SysUsersMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description: 用户信息
 * @author: zhangshuai
 * @create: 2019-11-08 10:42
 */
@Service
public class SysUsersService extends BaseService<SysUsersMapper, SysUsers> {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private ProvideMicroService provideMicroService;

    /**
     * 保存
     * @param sysUsers
     * @return
     */
    @GlobalTransactional
    public Result saveSysUsers(SysUsers sysUsers){

        Date date = new Date();

        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setName("分布式事务测试");
        sysAuthority.setSysUsersId(9);
        sysAuthority.setFlagDelete(false);
        sysAuthority.setCreateTime(date);
        sysAuthority.setUpdateTime(date);

        provideMicroService.saveSysAuthority(sysAuthority);
        sysUsersMapper.insertSelective(sysUsers);
        provideMicroService.saveSysAuthority1(sysAuthority);
        return ResultUtil.success();
    }



    @Reference
    private ProvideMicroService articleMicroDubboService;

    @GlobalTransactional
    public Result saveSysUsersDubbo(SysUsers sysUsers){
        Date date = new Date();

        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setName("分布式事务测试");
        sysAuthority.setSysUsersId(9);
        sysAuthority.setFlagDelete(false);
        sysAuthority.setCreateTime(date);
        sysAuthority.setUpdateTime(date);

        articleMicroDubboService.saveSysAuthority(sysAuthority);
        sysUsersMapper.insertSelective(sysUsers);
        articleMicroDubboService.saveSysAuthority1(sysAuthority);

        return ResultUtil.success();
    }

}
