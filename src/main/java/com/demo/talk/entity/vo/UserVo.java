package com.demo.talk.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {
    private String name;
    private String password;
    private Integer sex;
    private Date birth;
    private Integer age;
    private Integer isDelete;
    private Date createTime;
    private Date modifyTime;
    private Integer online;
}
