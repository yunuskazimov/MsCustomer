package az.bank.customer.service;

import az.bank.customer.model.CustomerDto;

import java.util.List;


public interface CustomerService {

    CustomerDto createCustomer(CustomerDto dto);

    CustomerDto editCustomer(CustomerDto dto);

    CustomerDto editCustomerSomeData(CustomerDto dto);

    CustomerDto getCustomer(Long id);

    List<CustomerDto> getCustomers();

    void deteleCustomer(Long id);

  //  CustomerDto migrateCustomer(Long id);

}
