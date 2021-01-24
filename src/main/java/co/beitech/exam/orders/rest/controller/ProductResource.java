package co.beitech.exam.orders.rest.controller;

import co.beitech.exam.orders.rest.dto.ProductDTO;
import co.beitech.exam.orders.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<ProductDTO>> list(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(productService.list(page, size));
    }
}
