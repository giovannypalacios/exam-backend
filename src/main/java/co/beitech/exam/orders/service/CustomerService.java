package co.beitech.exam.orders.service;

import co.beitech.exam.orders.factory.CustomerFactory;
import co.beitech.exam.orders.model.Customer;
import co.beitech.exam.orders.repository.CustomerRepository;
import co.beitech.exam.orders.rest.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Page<CustomerDTO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customers = customerRepository.findAll(pageable);
        return new PageImpl<>(CustomerFactory.buildDTOs(customers.getContent()), pageable, customers.getTotalElements());
    }

    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow();
        return CustomerFactory.buildDTO(customer);
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository
                .findById(customerId)
                .orElseThrow();
    }
}
