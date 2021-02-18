package com.zherke.rexxar.common.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zherke.rexxar.common.entity.BaseEntity;
import com.zherke.rexxar.common.service.IBaseService;

/**
 * 基础MybatisService
 *      可定制化部分方法
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/4 11:21
 */
public abstract class BaseMybatisService<T extends BaseEntity, M extends BaseMapper<T>> extends ServiceImpl<M,T> implements IBaseService<T> {
}
