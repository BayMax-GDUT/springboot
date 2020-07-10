package com.cvaiedu.springboot.system.controller;

import com.alibaba.druid.util.StringUtils;
import com.cvaiedu.springboot.exception.FrameworkException;
import com.cvaiedu.springboot.result.Result;
import com.cvaiedu.springboot.system.service.inter.CaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/v1/auth")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CaptchaService captchaService;

    @GetMapping(value = "/captcha")
    public Result captcha(@RequestParam String uuid) {

        if (uuid == null || StringUtils.isEmpty(uuid)) {
            throw new FrameworkException("");
        }
        return Result.ok(captchaService.getCaptcha(uuid));
    }
}
