package com.cvaiedu.springboot.system.service.inter;

import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public interface CaptchaService {

    BufferedImage getCaptcha(String uuid);
}
