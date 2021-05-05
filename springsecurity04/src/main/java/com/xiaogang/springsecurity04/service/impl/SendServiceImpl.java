package com.xiaogang.springsecurity04.service.impl;

import com.xiaogang.springsecurity04.service.SendService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName : security
 * @作者 : 侯小刚
 * @描述 :
 * @创建日期 : 2021/5/5 21:04
 */
@Service
public class SendServiceImpl implements SendService {
    @Override
    public void send() {
        System.out.println("发送邮件");
    }
}
