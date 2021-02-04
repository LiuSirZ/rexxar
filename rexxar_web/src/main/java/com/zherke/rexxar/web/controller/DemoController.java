package com.zherke.rexxar.web.controller;

import com.zherke.rexxar.common.entity.BaseResponseVo;
import com.zherke.rexxar.common.utils.ResponseUtil;
import com.zherke.rexxar.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/2 16:03
 */
@RestController
public class DemoController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/test")
    public BaseResponseVo<?> test(){

        orderService.ins();
        Map<String,String> map = new HashMap<>();
        return ResponseUtil.success(map);
    }
}
