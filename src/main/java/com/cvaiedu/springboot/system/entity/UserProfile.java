package com.cvaiedu.springboot.system.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * user_profile
 * @author 
 */
@Accessors(chain = true)
@NoArgsConstructor
@Data
public class UserProfile implements Serializable {
    private Long id;

    private Long userId;

    private String name;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;
}