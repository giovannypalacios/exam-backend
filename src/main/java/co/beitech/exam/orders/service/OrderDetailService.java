package co.beitech.exam.orders.service;

import co.beitech.exam.orders.factory.OrderDetailFactory;
import co.beitech.exam.orders.model.OrderDetail;
import co.beitech.exam.orders.repository.OrderDetailRepository;
import co.beitech.exam.orders.rest.dto.OrderDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    public List<OrderDetailDTO> list() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        return OrderDetailFactory.buildDTOs(orderDetails);
    }
}
