package co.beitech.exam.orders.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private CustomerDTO customer;
    private Date creationDate;
    private String deliveryAddress;
    private Double total;
}
