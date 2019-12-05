package com.example.consume.controller;

import com.example.commoncomponets.entity.consume.pm.SysUsers;
import com.example.commoncomponets.utils.Result;
import com.example.consume.service.SysUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @description: 用户信息
 * @author: zhangshuai
 * @create: 2019-11-08 10:47
 */
@Api(description = "用户信息")
@RestController
@RequestMapping(value = "/sysUsers")
public class SysUsersController {

    private final Logger logger = Logger.getLogger("SysUsersController");

    @Autowired
    private SysUsersService sysUsersService;

    @ApiOperation(
            value = "保存",
            notes = "保存",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveSysUsers",method=RequestMethod.POST)
    public Result saveSysUsers(@RequestBody SysUsers sysUsers){
        return sysUsersService.saveSysUsers(sysUsers);
    }


    @ApiOperation(
            value = "dubbo保存",
            notes = "dubbo保存",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveSysUsersDubbo",method=RequestMethod.POST)
    public Result saveSysUsersDubbo(@RequestBody SysUsers sysUsers){
        return sysUsersService.saveSysUsersDubbo(sysUsers);
    }

}
