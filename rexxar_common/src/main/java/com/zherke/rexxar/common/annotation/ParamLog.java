package com.zherke.rexxar.common.annotation;

import com.zherke.rexxar.common.enums.LogType;

import java.lang.annotation.*;

/**
 * 出参入参参数打印
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/13 16:54
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamLog {
    /**
     * 调用方法名称
     */
    String method();

    /**
     * 日志类型
     */
    LogType logType();
}
