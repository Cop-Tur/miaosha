package com.miaoshaproject.error;

/**
 * @Description
 * @Author yaoyw@asiainfo.com
 * @Date 2020/8/14 14:56
 */
public enum EmBusinessError implements CommonError  {
    //通用错误类型  "参数不合法"可以根据场景通过setErrMsg修改
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),

    UNKNOWN_ERROR(10002,"未知错误"),

    //2开头为用户信息相关错误码
    USER_NOT_EXIST(20001,"用户不存在"),
    ;

    private int errCode;
    private String errMsg;

    EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
