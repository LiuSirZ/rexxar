package com.zherke.rexxar.common.entity;

import lombok.Data;

/**
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/18 11:53
 */
@Data
public class BaseRequestParam {
    /**
     * 操作人名称
     */
    private String userName;

    /**
     * 操作人ip
     */
    private String userIp;
}
