package co.beitech.exam.orders.service;

import co.beitech.exam.orders.factory.OrderDetailFactory;
import co.beitech.exam.orders.factory.OrderFactory;
import co.beitech.exam.orders.model.Order;
import co.beitech.exam.orders.model.OrderDetail;
import co.beitech.exam.orders.repository.OrderDetailRepository;
import co.beitech.exam.orders.repository.OrderRepository;
import co.beitech.exam.orders.rest.dto.OrderDTO;
import co.beitech.exam.orders.rest.dto.OrderDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public Page<OrderDTO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> pagedOrders = orderRepository.findAll(pageable);
        return new PageImpl<>(OrderFactory.buildDTOs(pagedOrders.getContent()), pageable, pagedOrders.getTotalElements());
    }

    public Page<OrderDTO> customerOrders(Long customerId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> pagedOrders = orderRepository.findByCustomerId(customerId, pageable);
        return new PageImpl<>(OrderFactory.buildDTOs(pagedOrders.getContent()), pageable, pagedOrders.getTotalElements());
    }

    public List<OrderDetailDTO> orderDetails(Long orderId) {
        List<OrderDetail> pagedOrders = orderDetailRepository.findByOrderId(orderId);
        return OrderDetailFactory.buildDTOs(pagedOrders);
    }
}
