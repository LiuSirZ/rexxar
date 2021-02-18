package com.zherke.rexxar.common.function;

/**
 * 函数式接口
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/4 15:47
 */
@FunctionalInterface
public interface DemoFunction<T> {
    T doTest();
}
