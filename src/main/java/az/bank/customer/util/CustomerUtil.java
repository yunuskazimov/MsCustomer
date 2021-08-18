package az.bank.customer.util;

import az.bank.customer.dao.CustomerEntity;
import az.bank.customer.model.exception.CustomerNotFoundException;
import az.bank.customer.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {
    private final CustomerRepository customerRepository;

    public CustomerUtil(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity findCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found with this ID"));
    }
}
