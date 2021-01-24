package co.beitech.exam.orders.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    private Long id;
    private Date creationDate;
    private String deliveryAddress;
    private Double total;
    private List<OrderDetailDTO> orderDetailList;
}
