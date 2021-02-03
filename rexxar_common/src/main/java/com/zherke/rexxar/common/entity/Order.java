package com.zherke.rexxar.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lwb
 * @version 1.0.0
 * @since 2021/2/3 11:10
 */
@Data
@TableName(value = "t_order")
public class Order {
    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
    private Long orderId;
    @TableField(value = "user_id")
    private String userId;
}
