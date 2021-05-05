package com.xiaogang.springsecurity04.config;

import com.xiaogang.springsecurity04.controller.IndexController;
import com.xiaogang.springsecurity04.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @ProjectName : security
 * @作者 : 侯小刚
 * @描述 :
 * @创建日期 : 2021/5/5 21:02
 */
public class CustomSavedRequestAwareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private SendService sendService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        this.logger.info(String.format("IP %s，用户 %s， 于 %s 成功登录系统。", request.getRemoteHost(), authentication.getName(), LocalDateTime.now()));
        sendService.send();
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
