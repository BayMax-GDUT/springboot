package com.cvaiedu.springboot.system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class LoginDTO {

    private String accountCode;

    private String password;

    private String captcha;

    private String uuid;

}
