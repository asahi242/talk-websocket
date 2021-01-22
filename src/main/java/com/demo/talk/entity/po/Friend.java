package com.demo.talk.entity.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer friendId;
    private Integer groupNum;
    private Integer isDelete;
    private Date createTime;
    private Date modifyTime;
}
