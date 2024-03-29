package com.example.order.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface OrderManager {

    Boolean order(OrderProduct order) throws JsonProcessingException;

}
