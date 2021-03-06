package com.cvaiedu.springboot.business.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * teacher
 * @author 
 */
@Accessors(chain = true)
@NoArgsConstructor
@Data
public class Teacher implements Serializable {

    private Long id;

    private Long userId;

    /**
     * 教师标签
     */
    private String tag;

    /**
     * 教师图片
     */
    private String img;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

}