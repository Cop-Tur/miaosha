package com.miaoshaproject.error;

/**
 * @Description
 * @Author yaoyw@asiainfo.com
 * @Date 2020/8/14 14:54
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
