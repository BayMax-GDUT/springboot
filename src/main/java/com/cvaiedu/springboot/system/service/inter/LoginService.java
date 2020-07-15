package com.cvaiedu.springboot.system.service.inter;

import com.cvaiedu.springboot.system.dto.LoginDTO;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Map;

public interface LoginService {

    BufferedImage getCaptcha(String uuid);

    Map<String, Object> login(LoginDTO loginDTO);
}
