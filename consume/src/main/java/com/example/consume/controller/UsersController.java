package com.example.consume.controller;

import com.example.commoncomponets.feignClient.provide.ProvideMicroService;
import com.example.commoncomponets.utils.Result;
import com.example.commoncomponets.utils.ResultUtil;
import com.example.consume.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


/**
 * @description: 用户基础服务
 * @author: zhangshuai
 * @create: 2018-10-25 14:49
 */
@Api(description = "用户信息")
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    private final Logger logger = Logger.getLogger("UserController");

    @Autowired
    private ProvideMicroService provideMicroService;


    @ApiOperation(
            value = "用户信息",
            notes = "用户信息",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getUser",method=RequestMethod.GET)
    public Result getUser() {
        return provideMicroService.getUser();
    }


    @Reference
    private ProvideMicroService userMicroDubboService;

    @ApiOperation(
            value = "用户信息dubbo",
            notes = "用户信息dubbo",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getUserDubbo",method=RequestMethod.GET)
    public Result getUserDubbo() {
        return userMicroDubboService.getUser();
    }


    @Autowired
    private UserService userService;

    @ApiOperation(
            value = "用户信息-Consume",
            notes = "用户信息-Consume",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getConsume",method=RequestMethod.GET)
    public Result getConsume() {
        return userService.getUser();
    }




    //使用 MessageChannel 进行消息发送

    @Autowired
    private MessageChannel output;

    @ApiOperation(
            value = "mq发送",
            notes = "mq发送",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/sendMQ",method=RequestMethod.GET)
    public Result sendMQ() {

        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "tagStr");
        Message message = MessageBuilder.createMessage("111111111111111111", new MessageHeaders(headers));
        output.send(message);

        return ResultUtil.success("发送MQ消息成功!");
    }

}
