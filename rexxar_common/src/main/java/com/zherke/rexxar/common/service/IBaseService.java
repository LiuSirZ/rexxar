package com.zherke.rexxar.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zherke.rexxar.common.entity.BaseEntity;

/**
 * MybatisPlus
 * 自定义通用Service
 * 如果需要自定义方法在此接口中编写
 * @author lwb
 * @since 2020/02/04
 * @version 1.0
 * @param <T> T extends BaseEntity
 */
public interface IBaseService<T extends BaseEntity> extends IService<T> {

}
