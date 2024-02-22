package com.example.order.web.stock;

import com.example.order.domain.OrderProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class StockManagerImpl implements StockManager{

    private ObjectMapper objectMapper;

    private RabbitTemplate rabbitTemplate;

    public StockManagerImpl(ObjectMapper objectMapper, RabbitTemplate rabbitTemplate) {
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }

    @Override
    public Boolean postProduct(OrderProduct orderProduct) {

        try {
            String json = objectMapper.writeValueAsString(orderProduct);
            rabbitTemplate.convertAndSend("myQueue", json);
            return Boolean.TRUE;
        } catch (JsonProcessingException e) {
            return Boolean.FALSE;
        }

    }

}
