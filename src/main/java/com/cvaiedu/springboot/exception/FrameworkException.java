package com.cvaiedu.springboot.exception;

import com.cvaiedu.springboot.result.ResultEnum;

public class FrameworkException extends RuntimeException {

    private String msg;

    private int code = ResultEnum.ERROR_500.getCode();

    public FrameworkException() {
        super();
        this.msg = ResultEnum.ERROR_500.getMsg();
    }

    public FrameworkException(String msg) {
        super(msg);
        this.msg = ResultEnum.ERROR_500.getMsg();
    }

    public FrameworkException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public FrameworkException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.msg = resultEnum.getMsg();
        this.code = resultEnum.getCode();
    }

    public FrameworkException(Throwable t) {
        super(t);
    }

    public FrameworkException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }

    public FrameworkException(int code, String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return this.code;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return this.msg;
    }
}
