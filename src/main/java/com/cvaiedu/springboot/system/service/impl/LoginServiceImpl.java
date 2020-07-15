package com.cvaiedu.springboot.system.service.impl;

import com.cvaiedu.springboot.business.entity.Teacher;
import com.cvaiedu.springboot.business.service.inter.TeacherService;
import com.cvaiedu.springboot.constant.ConstantValue;
import com.cvaiedu.springboot.exception.FrameworkException;
import com.cvaiedu.springboot.system.dto.LoginDTO;
import com.cvaiedu.springboot.system.entity.Account;
import com.cvaiedu.springboot.system.entity.OnlineUserInfo;
import com.cvaiedu.springboot.system.entity.UserProfile;
import com.cvaiedu.springboot.system.service.inter.AccountService;
import com.cvaiedu.springboot.system.service.inter.LoginService;
import com.cvaiedu.springboot.system.service.inter.UserProfileService;
import com.cvaiedu.springboot.utils.RedisUtils;
import com.cvaiedu.springboot.utils.TokenUtils;
import com.google.code.kaptcha.Producer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private TokenUtils tokenUtils;

    @Resource
    private Producer producer;

    @Resource
    private AccountService accountService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private UserProfileService userProfileService;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        // 获取随机code
        String code = producer.createText();
        String captchaKey = getCaptchaKey(uuid);
        redisUtils.set(captchaKey, code, ConstantValue.CAPTCHA_VALID_TIME);

        return producer.createImage(code);
    }

    private Boolean checkCaptcha(String captcha, String uuid) {
        String captchaValue = redisUtils.get(getCaptchaKey(uuid));
        return captcha.equals(captchaValue);
    }

    @Override
    public Map<String, Object> login(LoginDTO loginDTO) {

        // 先校验验证码
        Boolean captchaBool = checkCaptcha(loginDTO.getCaptcha(), loginDTO.getUuid());
        if (!captchaBool) {
            throw new FrameworkException("验证码错误");
        }
        // 验证账号与密码
        Account account = accountService.selectOne(new Account().setAccountCode(loginDTO.getAccountCode()).setPassword(loginDTO.getPassword()));
        if (account == null) {
            throw new FrameworkException("用户名或密码错误");
        }
        redisUtils.delete(getCaptchaKey(loginDTO.getUuid()));
        userProfileService.selectOne(new UserProfile().setUserId(account.getId()));
        // 生成随机token
        String token = tokenUtils.createToken();
        // 拼接需要缓存的用户信息
        OnlineUserInfo onlineUserInfo = new OnlineUserInfo()
                .setAccountCode(account.getAccountCode())
                .setId(account.getId())
                .setType(account.getType());
        // 教师
        if (account.getType().equals(1)) {
            Teacher teacher = teacherService.selectOne(new Teacher().setUserId(account.getId()));
            onlineUserInfo.setImg(teacher.getImg());
            onlineUserInfo.setTag(teacher.getTag());
        }
        redisUtils.set("online:user:" + token, onlineUserInfo, ConstantValue.TOKEN_VALID_TIME);
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        return result;
    }

    private static String getCaptchaKey(String uuid) {
        return "captcha_key_" + uuid;
    }
}
