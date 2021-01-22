package co.beitech.exam.orders.factory;

import co.beitech.exam.orders.model.Product;
import co.beitech.exam.orders.rest.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class ProductFactory {

    private ProductFactory() {
    }

    public static Product buildEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

    public static ProductDTO buildDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public static List<ProductDTO> buildDTOs(List<Product> products) {
        return products
                .stream()
                .map(ProductFactory::buildDTO)
                .collect(Collectors.toList());
    }
}
