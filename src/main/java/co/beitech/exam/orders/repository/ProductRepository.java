package co.beitech.exam.orders.repository;

import co.beitech.exam.orders.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
