package com.zherke.rexxar.common.annotation;

import com.zherke.rexxar.common.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 动账通知操作记录
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/10 11:14
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoticeOperatorRecord {
    /**
     * 设置需要记录的操作日志类型
     *
     * @return
     */
    OperatorType value();

    /**
     * 操作方法描述
     * @return
     */
    String method();
}

