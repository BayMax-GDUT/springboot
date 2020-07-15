package com.cvaiedu.springboot.system.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.cvaiedu.springboot.exception.FrameworkException;
import com.cvaiedu.springboot.result.Result;
import com.cvaiedu.springboot.system.dto.LoginDTO;
import com.cvaiedu.springboot.system.service.inter.AccountService;
import com.cvaiedu.springboot.system.service.inter.LoginService;
import com.cvaiedu.springboot.system.service.inter.UserProfileService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping(value = "/v1/auth")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginService loginService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping(value = "/captcha")
    public void captcha(@RequestParam String uuid, HttpServletResponse response) {
        logger.info("获取验证码, 参数 = {}", uuid);
        if (uuid == null || StringUtils.isEmpty(uuid)) {
            throw new FrameworkException("获取验证码失败");
        }
        try {
            response.setHeader("Cache-Control", "no-store, no-cache");
            response.setContentType("image/jpeg");
            BufferedImage captcha = loginService.getCaptcha(uuid);
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(captcha, "JPEG", outputStream);
            IOUtils.closeQuietly(outputStream);
        } catch (Exception e) {
            throw new FrameworkException(e.getMessage());
        }
    }

    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        logger.info("用户登录， 参数 = {}", JSONObject.toJSONString(loginDTO));
        return Result.ok(loginService.login(loginDTO));
    }
}
