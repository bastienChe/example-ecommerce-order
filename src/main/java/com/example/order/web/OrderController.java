package com.example.order.web;

import com.example.order.domain.OrderProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("order-product")
    @PostMapping
    public ResponseEntity<OrderProductDTO> orderProduct(@RequestParam("id") int id,
                                                        @RequestParam("name") String name,
                                                        @RequestParam("quantity") int quantity) {

        OrderProductDTO orderProductDTO = new OrderProductDTO(id, name, quantity);

        OrderProduct orderProduct = OrderProductDTO.to(orderProductDTO);

    }

}