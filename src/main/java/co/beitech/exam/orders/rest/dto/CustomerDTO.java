package co.beitech.exam.orders.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private List<OrderDTO> orders;
}
