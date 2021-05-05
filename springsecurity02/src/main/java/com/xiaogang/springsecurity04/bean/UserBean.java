package com.xiaogang.springsecurity04.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName : security
 * @作者 : 侯小刚
 * @描述 :
 * @创建日期 : 2021/5/4 15:25
 */
@Data
public class UserBean {

    private String name;
    private Integer age;
    private String sex;
    private List<String> tags;
    private boolean isAlive;
    private Date createTime;
}
