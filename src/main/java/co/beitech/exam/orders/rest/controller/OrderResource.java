package co.beitech.exam.orders.rest.controller;

import co.beitech.exam.orders.rest.dto.OrderDTO;
import co.beitech.exam.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderResource {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> list() {
        return ResponseEntity.ok(orderService.list());
    }
}
