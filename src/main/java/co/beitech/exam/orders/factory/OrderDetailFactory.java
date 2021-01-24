package co.beitech.exam.orders.factory;

import co.beitech.exam.orders.model.OrderDetail;
import co.beitech.exam.orders.rest.dto.OrderDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public final class OrderDetailFactory {

    private OrderDetailFactory() {
    }

    public static OrderDetail buildEntity(OrderDetailDTO dto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(dto.getId());
        orderDetail.setProduct(ProductFactory.buildEntity(dto.getProduct()));
        orderDetail.setProductDescription(dto.getProductDescription());
        orderDetail.setPrice(dto.getPrice());
        orderDetail.setQuantity(dto.getQuantity());
        return orderDetail;
    }

    public static OrderDetailDTO buildDTO(OrderDetail orderDetail) {
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setId(orderDetail.getId());
        dto.setProduct(ProductFactory.buildDTO(orderDetail.getProduct()));
        dto.setProductDescription(orderDetail.getProductDescription());
        dto.setPrice(orderDetail.getPrice());
        dto.setQuantity(orderDetail.getQuantity());
        return dto;
    }

    public static List<OrderDetailDTO> buildDTOs(List<OrderDetail> list) {
        return list
                .stream()
                .map(OrderDetailFactory::buildDTO)
                .collect(Collectors.toList());
    }

    public static Page<OrderDetailDTO> buildPagedDTOs(Page<OrderDetail> orderDetailPage) {
        List<OrderDetail> ordersList = orderDetailPage.getContent();
        return new PageImpl<>(buildDTOs(ordersList));
    }
}

