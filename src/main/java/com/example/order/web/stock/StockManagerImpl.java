package com.example.order.web.stock;

import com.example.order.domain.OrderProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class StockManagerImpl implements StockManager{

    @Value("${stock.uri.product}")
    String stockProduitUri;

    private final RestClient restClient;

    private ObjectMapper objectMapper;

    public StockManagerImpl(@Value("${stock.uri.base}") String stockUriBase, ObjectMapper objectMapper) {
        restClient = RestClient.builder()
                .baseUrl(stockUriBase)
                .build();
        this.objectMapper = objectMapper;
    }


    @Override
    public Boolean postProduct(OrderProduct orderProduct) throws JsonProcessingException {
        StockProductDTO stockProductDTO = StockProductDTO.from(orderProduct);

        return restClient.post()
                .uri(stockProduitUri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stockProductDTO))
                .retrieve()
                .body(Boolean.class);

    }
}
