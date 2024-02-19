package com.example.order.web.stock;

import com.example.order.domain.OrderProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface StockManager {

    Boolean postProduct(OrderProduct orderProduct) throws JsonProcessingException;
}
