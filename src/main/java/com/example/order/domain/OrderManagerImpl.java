package com.example.order.domain;

import org.springframework.stereotype.Component;

@Component
public class OrderManagerImpl implements OrderManager {

    @Override
    public OrderProduct order(OrderProduct orderProduct) {
        return orderProduct;
    }
}
