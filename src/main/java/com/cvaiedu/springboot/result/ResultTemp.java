package com.cvaiedu.springboot.result;


import java.util.HashMap;


/**
 * 返回数据
 */
public class ResultTemp extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultTemp() {
        put("status", ResultEnum.SUCCESS.getCode());
        put("msg", "success");
        put("data", null);
    }

    public static ResultTemp error() {
        return error(ResultEnum.ERROR_500.getCode(), "系统错误，请联系管理员");
    }

    public static ResultTemp error(String msg) {
        return error(ResultEnum.ERROR_500.getCode(), msg);
    }

    public static ResultTemp error(int code, String msg) {
        ResultTemp r = new ResultTemp();
        r.put("status", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultTemp ok() {
        return new ResultTemp();
    }

    public static ResultTemp ok(Object object) {
        ResultTemp r = new ResultTemp();
        r.put("data", object);
        return r;
    }
}
