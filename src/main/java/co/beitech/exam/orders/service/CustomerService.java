package co.beitech.exam.orders.service;

import co.beitech.exam.orders.factory.CustomerFactory;
import co.beitech.exam.orders.model.Customer;
import co.beitech.exam.orders.repository.CustomerRepository;
import co.beitech.exam.orders.rest.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDTO> list() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerFactory.buildDTOs(customers);
    }
}
