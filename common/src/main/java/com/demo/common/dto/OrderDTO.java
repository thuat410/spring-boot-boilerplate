package com.demo.common.dto;

import com.demo.common.enums.OrderStatusEnum;
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
