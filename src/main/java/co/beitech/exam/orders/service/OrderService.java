package co.beitech.exam.orders.service;

import co.beitech.exam.orders.factory.OrderDetailFactory;
import co.beitech.exam.orders.factory.OrderFactory;
import co.beitech.exam.orders.factory.ProductFactory;
import co.beitech.exam.orders.model.Customer;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    CustomerService customerService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public Page<OrderDTO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> pagedOrders = orderRepository.findAll(pageable);
        return new PageImpl<>(OrderFactory.buildDTOs(pagedOrders.getContent()), pageable, pagedOrders.getTotalElements());
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    public Page<OrderDTO> customerOrders(Long customerId, int page, int size, Date start, Date end) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> pagedOrders = orderRepository.findByCustomerIdAndCreationDateBetweenOrderByCreationDateDesc(
                customerId,
                pageable,
                start,
                end);
        return new PageImpl<>(OrderFactory.buildDTOs(pagedOrders.getContent()), pageable, pagedOrders.getTotalElements());
    }

    public OrderDTO addOrder(Long customerId, OrderDTO orderDTO) {
        if (orderDTO.getOrderDetailList().size() > 5)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot add more than 5 products");
        Customer customer = customerService.getCustomer(customerId);
        OrderDetailDTO disallowedProduct = orderDTO
                .getOrderDetailList()
                .stream()
                .filter(orderDetailDTO -> !customer.getAvailableProducts().contains(ProductFactory.buildEntity(orderDetailDTO.getProduct())))
                .findAny()
                .orElse(null);

        if (disallowedProduct != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The order has some products not available for the customer");

        Order newOrder = OrderFactory.buildEntity(orderDTO);
        newOrder.setCustomer(customer);
        orderRepository.save(newOrder);

        List<OrderDetail> orderDetailsList = orderDTO
                .getOrderDetailList()
                .stream()
                .map(OrderDetailFactory::buildEntity)
                .collect(Collectors.toList());

        orderDetailsList.forEach(orderDetail -> orderDetail.setOrder(newOrder));

        orderDetailRepository.saveAll(orderDetailsList);

        return OrderFactory.buildDTO(newOrder);
    }
}
