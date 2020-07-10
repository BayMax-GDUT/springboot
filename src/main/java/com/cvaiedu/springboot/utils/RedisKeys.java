package com.cvaiedu.springboot.utils;

/**
 * Redis所有Keys
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-18 19:51
 */
public class RedisKeys {

    /**
     * 图形验证码redisKey
     *
     * @param key
     * @return
     */
    public static String getCaptchaKey(String key) {
        return "buss:captcha:" + key;
    }


    /**
     * 登录tokenKey
     *
     * @param token
     * @return
     */
    public static String getLoginKey(String token) {
        return "framework:login:token:" + token;
    }


    /**
     * 当前用户,使用userId为key
     *
     * @param userId
     * @return
     */
    public static String getOnlineUserKey(Long userId) {
        return "framework:online:user:" + userId;
    }

    /**
     * 当前用户的所有权限，使用userId为key
     *
     * @param userId
     * @return
     */
    public static String getFrameworkAccountPermsKey(Long userId) {
        return "framework:account:perms:" + userId;
    }


    /**
     * workWX 全量同步间隔时间限制
     *
     * @param organizationId
     * @return
     */
    public static String getWorkWXTotalUpdateTimeLimit(Long organizationId) {
        return "workWX:totalUpdateTimeLimit:" + organizationId;
    }

    /**
     * workWX 通讯录应用接口的access_token
     *
     * @param organizationId
     * @return
     */
    public static String getWechatWorkAddressListKey(Long organizationId) {
        return "workWX:addressList:organizationId:" + organizationId;
    }

    /**
     * workWX 家校互通应用接口的access_token
     *
     * @param organizationId
     * @return
     */
    public static String getWechatWorkHomeSchoolKey(Long organizationId) {
        return "workWX:homeSchool:organizationId:" + organizationId;
    }

    /**
     * 机构企业微信配置状态
     *
     * @param organizationId
     * @return
     */
    public static String getWechatWorkPushKey(Long organizationId) {
        return "workWX:open:key:" + organizationId;
    }
}
