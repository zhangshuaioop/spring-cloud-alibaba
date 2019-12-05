package com.example.consume.controller;

import com.example.commoncomponets.entity.consume.elasticsearch.Person;
import com.example.commoncomponets.utils.Result;
import com.example.commoncomponets.utils.ResultUtil;
import com.example.consume.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @description: 人员
 * @author: zhangshuai
 * @create: 2019-11-08 10:47
 */
@Api(description = "人员")
@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final Logger logger = Logger.getLogger("SysTeamController");

    @Autowired
    private PersonService personService;

    @ApiOperation(
            value = "保存",
            notes = "保存",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/save",method=RequestMethod.GET)
    public Result save(){
        personService.save();
        return ResultUtil.success();
    }


    @ApiOperation(
            value = "查询",
            notes = "查询",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAll",method=RequestMethod.GET)
    public Result<Person> findAll(){
        return personService.findAll();
    }



    @ApiOperation(
            value = "删除",
            notes = "删除",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/delete",method=RequestMethod.GET)
    public Result delete(){
        return personService.deleteAll();
    }


}
