package com.example.order.web.order;

import com.example.order.domain.OrderManager;
import com.example.order.domain.OrderProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    private OrderManager orderManager;

    public OrderController(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @RequestMapping("order-product")
    @PostMapping
    public ResponseEntity<Boolean> orderProduct(@RequestParam("id") int id,
                                                        @RequestParam("name") String name,
                                                        @RequestParam("quantity") int quantity) throws JsonProcessingException {

        OrderProductDTO orderProductDTO = new OrderProductDTO(id, name, quantity);

        if (orderManager.order(OrderProductDTO.to(orderProductDTO))) {
            return ResponseEntity.ok(Boolean.TRUE);
        } else {
            return ResponseEntity.ok(Boolean.FALSE);
        }

    }

}
