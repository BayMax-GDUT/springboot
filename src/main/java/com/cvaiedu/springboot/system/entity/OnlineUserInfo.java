package com.cvaiedu.springboot.system.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * redis中缓存的用户信息格式
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class OnlineUserInfo {

    private Long id;

    private String accountCode;

    private Short type;

    /**
     * 教师标签
     */
    private String tag;

    /**
     * 教师图片
     */
    private String img;

}
