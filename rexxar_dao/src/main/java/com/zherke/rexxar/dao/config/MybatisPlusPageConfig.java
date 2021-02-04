package com.zherke.rexxar.dao.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 插件配置
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/3 17:33
 */
@Configuration
@MapperScan("com.zherke.rexxar.dao.mapper")
public class MybatisPlusPageConfig {

    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        //添加分页插件
        MybatisPlusInterceptor paginationInterceptor = new MybatisPlusInterceptor();
        paginationInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return paginationInterceptor;
    }
}
