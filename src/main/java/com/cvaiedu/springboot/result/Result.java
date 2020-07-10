package com.cvaiedu.springboot.result;

import java.util.HashMap;

public class Result extends HashMap<String, Object> {

    private Result() {
        put("msg", "success");
        put("code", ResultEnum.SUCCESS.getCode());
        put("data", null);
    }

    private Result(int code, String msg) {
        put("msg", msg);
        put("code", code);
    }

    public static Result ok() {
        return new Result();
    }

    public static Result ok(Object object) {
        Result result = new Result();
        result.put("data", object);
        return result;
    }

    public static Result error() {
        return new Result(ResultEnum.ERROR_500.getCode(), ResultEnum.ERROR_500.getMsg());
    }

    public static Result error(String msg) {
        return new Result(ResultEnum.ERROR_500.getCode(), msg);
    }

    public static Result error(ResultEnum resultEnum) {
        return new Result(resultEnum.getCode(), resultEnum.getMsg());
    }

    public static Result error(int code, String msg) {
        return new Result(code, msg);
    }
}
