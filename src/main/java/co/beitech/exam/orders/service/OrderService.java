package co.beitech.exam.orders.service;

import co.beitech.exam.orders.factory.OrderFactory;
import co.beitech.exam.orders.model.Order;
import co.beitech.exam.orders.repository.OrderRepository;
import co.beitech.exam.orders.rest.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderDTO> list() {
        List<Order> orders = orderRepository.findAll();
        return OrderFactory.buildDTOs(orders);
    }
}
