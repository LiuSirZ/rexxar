package com.zherke.rexxar.web.aspect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zherke.rexxar.common.annotation.ParamLog;
import com.zherke.rexxar.common.enums.LogType;
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
public class ParamLogAspect {
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Pointcut("@annotation(com.zherke.rexxar.common.annotation.ParamLog)")
    public void printLog() {}


    /**
     * 环绕通知
     *  记录操作耗时，并记录操作人和操作数据
     * @param point 切点
     * @return
     * @throws Throwable
     */
    @Around("printLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        long beginTime = System.currentTimeMillis();
        //获取方法签名
        MethodSignature signature = (MethodSignature) point.getSignature();
        //获取执行方法
        Method method = signature.getMethod();
        //获取增强方法上的注解
        ParamLog annotation = method.getAnnotation(ParamLog.class);

        //注解为空 直接执行方法返回
        if(annotation == null){
            return point.proceed();
        }

        //方法描述
        String methodDoc = annotation.method();
        //打印日志类型
        LogType logType = annotation.logType();

        //打印入参
        if(logType == LogType.ENTER || logType == LogType.ALL){
            printEntryLog(methodDoc, point, signature);
        }

        //执行方法
        Object result = point.proceed();

        //打印出参
        if(logType == LogType.OUTPUT || logType == LogType.ALL){
            long time = System.currentTimeMillis() - beginTime;
            printOutputLog(methodDoc, point, result, time);
        }

        return result;
    }

    /**
     * 打印出参
     * @param method   注解方法描述
     * @param result   方法返回参数
     * @param time     方法耗时
     */
    public void printOutputLog(String method, ProceedingJoinPoint point, Object result, long time){
        try{
            String className = point.getTarget().getClass().getName();
            log.info("class:{}_method:{} output param:{},time:{}", className, method, gson.toJson(result), time);
        }catch (Exception e){
            log.error("print output param log error :{}", ExceptionUtils.getStackTrace(e));
        }

    }

    /**
     * 打印入参
     * @param method    方法描述
     * @param point     方法切点
     * @param signature 方法签名
     */
    public void printEntryLog(String method, ProceedingJoinPoint point, MethodSignature signature){
        try{
            String className = point.getTarget().getClass().getName();

            //请求的参数 以json数组的形式保存
            Object[] args = point.getArgs();
            StringBuilder params = new StringBuilder();
            for (Object o : args) {
                String s = gson.toJson(o);
                params.append("|").append(s);
            }

            log.info("class:{}_method:{} entry param:{}", className, method, params.toString());
        }catch (Exception e){
            log.error("print entry param log error :{}",ExceptionUtils.getStackTrace(e));
        }

    }
}
