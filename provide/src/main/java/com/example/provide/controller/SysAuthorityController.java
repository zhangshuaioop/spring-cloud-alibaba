package com.example.provide.controller;

import com.example.commoncomponets.entity.provide.pm.SysAuthority;
import com.example.commoncomponets.utils.Result;
import com.example.provide.service.SysAuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @description: 权限信息
 * @author: zhangshuai
 * @create: 2019-11-08 10:23
 */
@Api(description = "权限信息")
@RestController
@RequestMapping(value = "/sysAuthority")
public class SysAuthorityController {

    private final Logger logger = Logger.getLogger("SysAuthorityController");

    @Autowired
    private SysAuthorityService sysAuthorityService;

    @ApiOperation(
            value = "保存",
            notes = "保存",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveSysAuthority",method=RequestMethod.POST)
    public Result saveSysAuthority(@RequestBody SysAuthority sysAuthority){
        logger.info("保存-入参:sysAuthority="+sysAuthority.toString());
        return sysAuthorityService.saveSysAuthority(sysAuthority);
    }


    @RequestMapping(value = "/saveSysAuthority1",method=RequestMethod.POST)
    public Result saveSysAuthority1(@RequestBody SysAuthority sysAuthority){
        logger.info("保存-入参:article="+sysAuthority.toString());
        return sysAuthorityService.saveSysAuthority1(sysAuthority);
    }

}
