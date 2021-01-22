package co.beitech.exam.orders.factory;

import co.beitech.exam.orders.model.Customer;
import co.beitech.exam.orders.rest.dto.CustomerDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class CustomerFactory {

    private CustomerFactory() {}

    public static Customer buildEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        return customer;
    }

    public static CustomerDTO buildDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        return dto;
    }

    public static List<CustomerDTO> buildDTOs(List<Customer> customers) {
        return customers
                .stream()
                .map(CustomerFactory::buildDTO)
                .collect(Collectors.toList());
    }
}
