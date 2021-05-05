package com.xiaogang.springsecurity04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @ProjectName : security
 * @作者 : 侯小刚
 * @描述 :
 * @创建日期 : 2021/5/4 12:50
 */
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义登录页
        http.formLogin().loginPage("/login").permitAll()
                //成功后要做的事
                .successHandler(customAuthenticationSuccessHandler())
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        CustomSavedRequestAwareAuthenticationSuccessHandler customSavedRequestAwareAuthenticationSuccessHandler = new CustomSavedRequestAwareAuthenticationSuccessHandler();
        //在这里写要默认跳转的页面
        customSavedRequestAwareAuthenticationSuccessHandler.setDefaultTargetUrl("/login1");
        customSavedRequestAwareAuthenticationSuccessHandler.setAlwaysUseDefaultTargetUrl(true);
        return customSavedRequestAwareAuthenticationSuccessHandler;
    }

}
