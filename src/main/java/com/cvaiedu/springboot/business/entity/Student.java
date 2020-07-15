package com.cvaiedu.springboot.business.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

    private Long id;

    private Long userId;

    private Date createTime;

    private Date modifyTime;

}
