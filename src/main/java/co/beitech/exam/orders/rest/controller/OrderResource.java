package co.beitech.exam.orders.rest.controller;

import co.beitech.exam.orders.rest.dto.OrderDTO;
import co.beitech.exam.orders.rest.dto.OrderDetailDTO;
import co.beitech.exam.orders.service.OrderDetailService;
import co.beitech.exam.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderResource {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<OrderDTO>> list(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(orderService.list(page, size));
    }

    @GetMapping("/{orderId}/order-details")
    @ResponseBody
    public ResponseEntity<List<OrderDetailDTO>> orderDetail(
            @PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(orderDetailService.orderDetails(orderId));
    }

}
