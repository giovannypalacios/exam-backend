package co.beitech.exam.orders.rest.controller;

import co.beitech.exam.orders.rest.dto.CustomerDTO;
import co.beitech.exam.orders.rest.dto.OrderDTO;
import co.beitech.exam.orders.rest.dto.ProductDTO;
import co.beitech.exam.orders.service.CustomerService;
import co.beitech.exam.orders.service.OrderService;
import co.beitech.exam.orders.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerResource {

    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<CustomerDTO>> list(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(customerService.list(page, size));
    }

    @GetMapping("/{customerId}")
    @ResponseBody
    public ResponseEntity<CustomerDTO> getCustomer(
            @PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/{customerId}/available-products")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> availableProducts(
            @PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(productService.customerProducts(customerId));
    }

    @GetMapping("/{customerId}/orders")
    @ResponseBody
    public ResponseEntity<Page<OrderDTO>> orders(
            @PathVariable("customerId") Long customerId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity
                .ok(orderService.customerOrders(customerId, page, size));
    }
}
