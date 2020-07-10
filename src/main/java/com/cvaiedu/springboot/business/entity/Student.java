package com.cvaiedu.springboot.business.entity;

import lombok.Data;

@Data
public class Student {

    private Long id;

    private Integer accountCode;

    private String name;

    private Long courseId;

}
