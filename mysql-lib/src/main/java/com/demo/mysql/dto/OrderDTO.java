package com.demo.mysql.dto;

import com.demo.mysql.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Long userId;
    private Set<Long> OrderItemIds;
    private OrderStatusEnum status;
}
