package co.beitech.exam.orders.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {

    private Long id;
    private OrderDTO order;
    private ProductDTO product;
    private String productDescription;
    private Double price;
    private int quantity;
}
