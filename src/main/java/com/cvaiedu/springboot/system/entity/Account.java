package com.cvaiedu.springboot.system.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * account
 * @author 
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Account implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private String accountCode;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型 1教师 2学生
     */
    private Short type;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;
}