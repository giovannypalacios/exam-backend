package co.beitech.exam.orders.repository;

import co.beitech.exam.orders.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findAll(Pageable pageable);

    Page<Order> findByCustomerId(Long customerId, Pageable pageable);

    Page<Order> findByCustomerIdAndCreationDateBetweenOrderByCreationDateDesc(
            Long customerId,
            Pageable pageable,
            Date start,
            Date end
    );
}
