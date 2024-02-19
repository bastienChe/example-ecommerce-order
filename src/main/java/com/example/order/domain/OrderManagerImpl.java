package com.example.order.domain;

import com.example.order.web.stock.StockManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class OrderManagerImpl implements OrderManager {

    StockManager stockManager;

    public OrderManagerImpl(StockManager stockManager) {
        this.stockManager = stockManager;
    }

    @Override
    public Boolean order(OrderProduct orderProduct) throws JsonProcessingException {
        return stockManager.postProduct(orderProduct);
    }
}
