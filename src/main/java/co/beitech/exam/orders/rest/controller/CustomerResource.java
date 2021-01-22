package co.beitech.exam.orders.rest.controller;

import co.beitech.exam.orders.rest.dto.CustomerDTO;
import co.beitech.exam.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerResource {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> list() {
        return ResponseEntity.ok(customerService.list());
    }
}
