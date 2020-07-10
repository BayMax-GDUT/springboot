package com.cvaiedu.springboot.business.vo;

import lombok.Data;

/**
 * 微信公众号相关
 */
@Data
public class UserVO {

    private String openId;

    private String sessionKey;
}
