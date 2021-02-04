package com.zherke.rexxar.service.impl;

import com.zherke.rexxar.common.entity.Order;
import com.zherke.rexxar.common.mybatis.BaseMybatisService;
import com.zherke.rexxar.dao.mapper.OrderMapper;
import com.zherke.rexxar.service.OrderService;
import org.springframework.stereotype.Service;


/**
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/4 11:19
 */
@Service
public class OrderServiceImpl extends BaseMybatisService<Order,OrderMapper> implements OrderService {

    @Override
    public void ins(){
        Order order = new Order();
        order.setUserId(11111);
        this.save(order);
    }
}
