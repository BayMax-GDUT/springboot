package com.cvaiedu.springboot.system.service.impl;

import com.cvaiedu.springboot.system.service.inter.CaptchaService;
import com.cvaiedu.springboot.utils.RedisUtils;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;

public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        // 获取随机code
        String code = producer.createText();
        String captchaKey = getCaptchaKey(uuid);
        redisUtils.set(captchaKey, code, 60);

        return producer.createImage(code);
    }

    private static String getCaptchaKey(String uuid) {
        return "captcha_key_" + uuid;
    }
}
