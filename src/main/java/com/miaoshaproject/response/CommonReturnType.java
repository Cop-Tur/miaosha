package com.miaoshaproject.response;

/**
 * @Description 通用返回类型
 * @Author yaoyw@asiainfo.com
 * @Date 2020/8/13 22:22
 */
public class CommonReturnType {
    //表明对应返回处理状态为"success"或"fail"
    private String state;

    //若为success，则data内返回前端需要的json数据
    //若为fail，则data内使用通用的错误码格式
    private Object data;

    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result, String state) {
        CommonReturnType type = new CommonReturnType();
        type.setData(result);
        type.setState(state);
        return type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
