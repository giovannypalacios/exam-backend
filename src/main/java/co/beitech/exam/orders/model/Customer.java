package co.beitech.exam.orders.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "customer_id")
    private Long id;
    private String name;
    private String email;
}
