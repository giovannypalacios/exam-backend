package co.beitech.exam.orders.rest.controller;

import co.beitech.exam.orders.rest.dto.OrderDetailDTO;
import co.beitech.exam.orders.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order-details")
public class OrderDetailResource {

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetailDTO>> list() {
        return ResponseEntity.ok(orderDetailService.list());
    }
}
