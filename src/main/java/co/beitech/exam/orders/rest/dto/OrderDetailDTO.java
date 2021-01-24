package co.beitech.exam.orders.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailDTO {
    private Long id;
    private ProductDTO product;
    private String productDescription;
    private Double price;
    private int quantity;
}
