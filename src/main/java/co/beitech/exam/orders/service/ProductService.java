package co.beitech.exam.orders.service;

import co.beitech.exam.orders.factory.ProductFactory;
import co.beitech.exam.orders.model.Product;
import co.beitech.exam.orders.repository.ProductRepository;
import co.beitech.exam.orders.rest.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerService customerService;

    public List<ProductDTO> list() {
        List<Product> products = productRepository.findAll();
        return ProductFactory.buildDTOs(products);
    }

    public List<ProductDTO> customerProducts(Long customerId) {
        List<Product> availableProducts = customerService.getCustomer(customerId).getAvailableProducts();
        return ProductFactory.buildDTOs(availableProducts);
    }

}
