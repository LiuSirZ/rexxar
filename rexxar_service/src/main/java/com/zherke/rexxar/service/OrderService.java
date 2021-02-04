package com.zherke.rexxar.service;

import com.zherke.rexxar.common.entity.Order;
import com.zherke.rexxar.common.service.IBaseService;

/**
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/4 11:15
 */
public interface OrderService extends IBaseService<Order> {
    void ins();
}
