package com.zherke.rexxar.common.utils;

import com.zherke.rexxar.common.constant.RespTipConstant;
import com.zherke.rexxar.common.entity.BaseResponseVo;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * 通用响应工具类封装
 *    设计目标：实现接口返回结构统一
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/2 14:29
 */
public class ResponseUtil {

    /**
     * 响应成功
     * @return     响应信息
     */
    public static BaseResponseVo<?> success(){
        return success(RespTipConstant.SUCCESS_MSG);
    }

    /**
     * 响应成功
     * @param msg  响应信息
     * @return     返回信息
     */
    public static BaseResponseVo<?> success(String msg){
       return success(msg,null);
    }

    /**
     * 响应成功
     * @param data  响应信息
     * @return      返回信息
     */
    public static BaseResponseVo<?> success(Object data){
        return success(RespTipConstant.SUCCESS_MSG, data);
    }

    /**
     * 响应成功
     * code: {@link com.zherke.rexxar.common.constant.RespTipConstant}
     * msg: {@link com.zherke.rexxar.common.constant.RespTipConstant}
     * @param msg   响应信息
     * @param data  响应结果集
     * @return      返回信息
     */
    private static BaseResponseVo<?> success(String msg, Object data){
        return response(RespTipConstant.SUCCESS, msg, data);
    }

    /**
     * 响应失败
     * @return  返回信息
     */
    public static BaseResponseVo<?> fail(){
        return fail(RespTipConstant.SUCCESS_MSG);
    }

    /**
     * 响应失败
     * @param msg 响应信息
     * @return    返回信息
     */
    public static BaseResponseVo<?> fail(String msg){
        return fail(msg,null);
    }

    /**
     * 响应失败
     * code: {@link com.zherke.rexxar.common.constant.RespTipConstant}
     * msg: {@link com.zherke.rexxar.common.constant.RespTipConstant}
     * @param msg   响应信息
     * @param data  响应结果集
     * @return      返回信息
     */
    private static BaseResponseVo<?> fail(String msg, Object data){
        return response(RespTipConstant.FAIL, msg, data);
    }

    /**
     * 通用返回方法
     * @param code  响应状态码
     * @param msg   响应信息
     * @param data  响应结果集
     * @return      返回封装实体
     */
    public static BaseResponseVo<?> response(String code, String msg, Object data){
        BaseResponseVo<Object> baseResponseVo = new BaseResponseVo<>();
        baseResponseVo.setRespCodeAndRespMsg(StringUtils.isEmpty(code)? RespTipConstant.SUCCESS : code,msg);
        Optional<?> dataOption = Optional.ofNullable(data);
        if(dataOption.isPresent()){
            baseResponseVo.setData(data);
        }
        return baseResponseVo;
    }

}
