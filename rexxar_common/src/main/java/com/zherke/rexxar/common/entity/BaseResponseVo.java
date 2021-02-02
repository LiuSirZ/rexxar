package com.zherke.rexxar.common.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
/**
 * 基础返回实体
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/2 14:34
 */
public class BaseResponseVo<T> {
    /**
     * 初始化Gson
     */
    private final static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    /**
     * 返回状态码
     */
    @Setter
    @Getter
    private String respCode;
    /**
     * 返回提示信息
     */
    @Setter
    @Getter
    private String respMsg;
    /**
     * 返回数据集
     */
    @Setter
    @Getter
    private T data;

    /**
     * 设置返回状态码和返回信息
     * @param respCode 响应状态码
     * @param respMsg  响应信息
     */
    public void setRespCodeAndRespMsg(String respCode, String respMsg){
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    /**
     * 设置返回状态码、返回信息以及结果集
     * @param respCode
     * @param respMsg
     * @param data
     */
    public void setRespCodeAndRespMsgAndData(String respCode, String respMsg, T data){
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.data = data;
    }
    /**
     * 复写toString方法 便于后续使用
     * @return 将当前类属性转换为json
     */
    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
