package com.example.order.web;

import com.example.order.domain.OrderProduct;

public record OrderProductDTO(int id, String name, int quantity) {

    public static OrderProduct to(OrderProductDTO orderProductDTO) {
        return new OrderProduct(orderProductDTO.id(), orderProductDTO.name(), orderProductDTO.quantity());
    }

    public static OrderProductDTO from(OrderProduct orderProduct) {
        return new OrderProductDTO(orderProduct.getId(), orderProduct.getName(), orderProduct.getQuantity());
    }
}
