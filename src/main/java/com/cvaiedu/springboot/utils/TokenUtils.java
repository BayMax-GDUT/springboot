package com.cvaiedu.springboot.utils;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

@Component
public class TokenUtils {

    public String createToken() {
        return IdUtil.randomUUID();
    }
}
