package co.beitech.exam.orders.service;

import co.beitech.exam.orders.factory.ProductFactory;
import co.beitech.exam.orders.model.Product;
import co.beitech.exam.orders.repository.ProductRepository;
import co.beitech.exam.orders.rest.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerService customerService;

    public Page<ProductDTO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pagedProducts = productRepository.findAll(pageable);
        return new PageImpl<>(ProductFactory.buildDTOs(pagedProducts.getContent()), pageable, pagedProducts.getTotalElements());
    }

    public List<ProductDTO> customerProducts(Long customerId) {
        List<Product> availableProducts = customerService.getCustomer(customerId).getAvailableProducts();
        return ProductFactory.buildDTOs(availableProducts);
    }

}
