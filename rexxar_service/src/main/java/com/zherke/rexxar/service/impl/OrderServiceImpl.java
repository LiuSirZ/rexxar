package com.zherke.rexxar.service.impl;

import com.zherke.rexxar.common.annotation.ParamLog;
import com.zherke.rexxar.common.entity.Order;
import com.zherke.rexxar.common.enums.LogType;
import com.zherke.rexxar.common.mybatis.BaseMybatisService;
import com.zherke.rexxar.dao.mapper.OrderMapper;
import com.zherke.rexxar.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


/**
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/4 11:19
 */
@Service
public class OrderServiceImpl extends BaseMybatisService<Order,OrderMapper> implements OrderService {

    @Override
    @ParamLog(method = "测试方法",logType = LogType.ALL)
    public void ins(){
        Order order = new Order();
        order.setUserId(11111);
        order.setUserName("jock");
        long i = 1364132651360657410L;
        Order byId = this.getById(i);
        System.out.println(byId);
        order.setUserName("jock");
    }
}
