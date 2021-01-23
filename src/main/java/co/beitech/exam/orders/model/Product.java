package co.beitech.exam.orders.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_id")
    private Long id;
    private String name;

    @Column(name = "product_description")
    private String description;
    private Double price;

    @ManyToMany(mappedBy = "availableProducts")
    private List<Customer> customers;
}
