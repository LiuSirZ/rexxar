package com.zherke.rexxar.web.controller;

import com.zherke.rexxar.common.entity.BaseResponseVo;
import com.zherke.rexxar.common.utils.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/test")
    public BaseResponseVo<?> test(){
        Map<String,String> map = new HashMap<>();
        map.put("2222","1111");
        map.put("3333","1111");
        map.put("4444","1111");
        map.put("5555","1111");
        map.put("6666","1111");
        return ResponseUtil.success(map);
    }
}
