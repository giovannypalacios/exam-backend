package co.beitech.exam.orders.rest.controller;

import co.beitech.exam.orders.factory.ProductFactory;
import co.beitech.exam.orders.rest.dto.CustomerDTO;
import co.beitech.exam.orders.rest.dto.ProductDTO;
import co.beitech.exam.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/available-products/{userId}")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> availableProducts(@PathVariable("userId") Long userId) throws Exception {
        return ResponseEntity
                .ok(ProductFactory
                        .buildDTOs(customerService.list(userId).getAvailableProducts()));
    }
}
