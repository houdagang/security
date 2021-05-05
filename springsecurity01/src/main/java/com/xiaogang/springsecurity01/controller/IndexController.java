package com.xiaogang.springsecurity01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName : security
 * @作者 : 侯小刚
 * @描述 :
 * @创建日期 : 2021/5/4 12:51
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/","/index"})
    public String toIndex() {
       return "index";
    }

}
