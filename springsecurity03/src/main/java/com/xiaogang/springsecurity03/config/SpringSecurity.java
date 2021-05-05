package com.xiaogang.springsecurity03.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ProjectName : security
 * @作者 : 侯小刚
 * @描述 :
 * @创建日期 : 2021/5/4 12:50
 */
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义登录页
        http.formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/login1",true)
                .and()
                // 过滤请求
                .authorizeRequests()
                //不让访问
                .antMatchers("/css/**").denyAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
    }

}
