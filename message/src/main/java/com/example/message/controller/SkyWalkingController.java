package com.example.message.controller;

import com.example.commoncomponets.entity.message.Email;
import com.example.commoncomponets.entity.message.SkyWalking;
import com.example.message.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


/**
 * @description: 链路追踪
 * @author: zhangshuai
 * @create: 2018-10-25 14:49
 */
@Api(description = "链路追踪")
@RestController
@RequestMapping(value = "/skyWalking")
public class SkyWalkingController {

    private final Logger logger = Logger.getLogger("SkyWalkingController");

    @Autowired
    private EmailService emailService;

    @ApiOperation(
            value = "链路追踪告警",
            notes = "链路追踪告警",
            consumes = "application/json",
            responseReference = "com.example.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/notify",method = RequestMethod.POST)
    public void notify(@RequestBody List<SkyWalking> skyWalkings){
        logger.info("链路追踪告警开始,入参:skyWalking="+skyWalkings.toString());

        for (SkyWalking skyWalking: skyWalkings) {

            Email email = new Email();
            email.setContext(skyWalking.getAlarmMessage());
            email.setEmails("1301505228@qq.com");
            email.setNickName("skyWalking");
            email.setSubject("链路追踪告警");
            emailService.send(email);
        }

        logger.info("链路追踪邮件告警结束");
    }


}
