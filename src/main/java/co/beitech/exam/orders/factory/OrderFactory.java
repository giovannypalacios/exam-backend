package co.beitech.exam.orders.factory;

import co.beitech.exam.orders.model.Order;
import co.beitech.exam.orders.rest.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class OrderFactory {

    private OrderFactory() {
    }

    public static Order buildEntity(OrderDTO dto) {
        Order order = null;
        if (dto != null) {
            order = new Order();
            order.setId(dto.getId());
            order.setCreationDate(dto.getCreationDate());
            order.setDeliveryAddress(dto.getDeliveryAddress());
            order.setTotal(dto.getTotal());
        }
        return order;
    }

    public static OrderDTO buildDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCreationDate(order.getCreationDate());
        dto.setDeliveryAddress(order.getDeliveryAddress());
        dto.setTotal(order.getTotal());
        dto.setOrderDetailList(order.getOrderDetails().stream().map(OrderDetailFactory::buildDTO).collect(Collectors.toList()));
        return dto;
    }

    public static List<OrderDTO> buildDTOs(List<Order> orders) {
        return orders
                .stream()
                .map(OrderFactory::buildDTO)
                .collect(Collectors.toList());
    }
}
