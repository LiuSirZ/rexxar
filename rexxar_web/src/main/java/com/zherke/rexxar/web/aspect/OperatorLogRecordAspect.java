package com.zherke.rexxar.web.aspect;

import com.zherke.rexxar.common.annotation.NoticeOperatorRecord;
import com.zherke.rexxar.common.entity.BaseRequestParam;
import com.zherke.rexxar.common.enums.OperatorType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * AOP创建 操作日志
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/10 11:05
 */
@Slf4j
@Aspect
@Component
public class OperatorLogRecordAspect {

    @Pointcut("@annotation(com.zherke.rexxar.common.annotation.NoticeOperatorRecord)")
    public void operateRecord() {}


    /**
     * 环绕通知
     *  记录操作耗时，并记录操作人和操作数据
     * @param point 切点
     * @return
     * @throws Throwable
     */
    @Around("operateRecord()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            recordOperator(point, time);
        } catch (Exception e) {
            log.error("operateRecord aspect is error :{}", ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    /**
     * 记录操作人
     * @param point 切点
     * @param time  操作耗时
     */
    private void recordOperator(ProceedingJoinPoint point, long time) {
        //获取方法签名
        MethodSignature signature = (MethodSignature) point.getSignature();
        //获取执行方法
        Method method = signature.getMethod();
        //请求的 类名、方法名
        String methodName = signature.getName();
        //获取增强方法上的注解
        NoticeOperatorRecord noticeOperatorRecord = method.getAnnotation(NoticeOperatorRecord.class);
        OperatorType operatorType = null;
        if(noticeOperatorRecord != null){
            //注解上的属性
            operatorType = noticeOperatorRecord.value();
            methodName = noticeOperatorRecord.method();
        }



        //请求的参数 以json数组的形式保存
        Object[] args = point.getArgs();
        try{
            //处理请求参数
            for (Object paramObj : args) {
                //请求参数默认继承基础请求参数类
                if(paramObj instanceof BaseRequestParam){
                    //获取操作人信息
                    BaseRequestParam baseRequestParam = (BaseRequestParam) paramObj;
                    String userName = baseRequestParam.getUserName();
                    String userIp = baseRequestParam.getUserIp();

                }
            }
            //保存操作哦日志
        }catch (Exception e){
            log.error("recordOperator is error :{}", ExceptionUtils.getStackTrace(e));
        }
    }

}
