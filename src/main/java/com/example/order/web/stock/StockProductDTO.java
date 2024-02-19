package com.example.order.web.stock;

import com.example.order.domain.OrderProduct;

public record StockProductDTO(int id, String name, int quantity) {
    public static StockProductDTO from(OrderProduct orderProduct) {
        return new StockProductDTO(orderProduct.getId(), orderProduct.getName(), orderProduct.getQuantity());
    }
}
