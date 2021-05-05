package com.xiaogang.springsecurity04.controller;

import com.xiaogang.springsecurity04.bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName : security
 * @作者 : 侯小刚
 * @描述 :
 * @创建日期 : 2021/5/4 12:51
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/","/index"})
    public String toIndex(Model model) {
        model.addAttribute("title","后台传递的标题");
        model.addAttribute("description","后台传递的description");
        UserBean bean = new UserBean();
        bean.setAge(25);
        bean.setAlive(true);
        bean.setName("张三");
        bean.setSex("1");
        List<String> tags = new ArrayList<>();
        tags.add("语文");
        tags.add("数学");
        tags.add("物理");
        bean.setTags(tags);
        bean.setCreateTime(new Date());
        model.addAttribute("user",bean);
        return "index";
    }

    @RequestMapping(value = "/login")
    public String toLogin() {
        System.out.println("login");
        return "login";
    }

    @RequestMapping(value = "/login1")
    public String toLogin1() {
        System.out.println("login1");
        return "login1";
    }

}
