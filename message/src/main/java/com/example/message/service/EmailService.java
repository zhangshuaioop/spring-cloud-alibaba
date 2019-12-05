package com.example.message.service;

import com.example.commoncomponets.entity.message.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description: 邮箱发送
 * @author: zhangshuai
 * @create: 2019-12-02 19:23
 */
@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    //发送邮件的邮箱
    @Value("${email.userName}")
    private String userName;

    //发送邮件的邮箱授权码
    @Value("${email.password}")
    private String password;

    //邮件发送服务器
    @Value("${email.host}")
    private String host;

    //服务器端口
    @Value("${email.port}")
    private int port;

    /**
     * 发送
     * @param email
     * @return
     */
    public boolean send(Email email){
        boolean status = false;
        SimpleEmail mail = new SimpleEmail();
        mail=(SimpleEmail) mail.setSSLOnConnect(true);
        // 设置邮箱服务器信息
        mail.setSmtpPort(port);
        mail.setHostName(host);
        // 设置密码验证器
        mail.setAuthentication(userName, password);
        try {
            // 设置邮件发送者
            //            mail.setFrom(userName);
            mail.setFrom(userName,email.getNickName());
            // 设置邮件接收者
            mail.addTo(email.getEmails());
            // 设置邮件编码
            mail.setCharset("UTF-8");

            // 设置邮件主题
            mail.setSubject(email.getSubject());

            // 设置邮件内容
            mail.setMsg(email.getContext());

            // 设置邮件发送时间
            mail.setSentDate(new Date());

            mail.setSocketTimeout(100*1000);

            mail.setSocketConnectionTimeout(100*1000);
            // 发送邮件
            mail.send();
            logger.info("发送成功!");

            status = true;
        } catch (EmailException e) {
            logger.info("发送失败!");
            logger.info(new Date() + " 发送邮件失败. 失败邮箱:" + email.getEmails());
            e.printStackTrace();
            return status;
        }
        return status;
    }

}
