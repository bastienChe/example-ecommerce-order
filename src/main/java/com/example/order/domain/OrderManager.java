package com.example.order.domain;

import org.springframework.stereotype.Service;

@Service
public interface OrderManager {

    OrderProduct order(OrderProduct order);

}
