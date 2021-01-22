package co.beitech.exam.orders.repository;

import co.beitech.exam.orders.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
