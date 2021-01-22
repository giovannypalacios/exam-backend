package co.beitech.exam.orders.repository;

import co.beitech.exam.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
