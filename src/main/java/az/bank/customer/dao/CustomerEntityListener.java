package az.bank.customer.dao;

import az.bank.customer.repository.CustomerHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

@Component
public class CustomerEntityListener {
    private static CustomerHistoryRepository customerHistoryRepository;

    @Autowired
    public void init(CustomerHistoryRepository customerHistoryRepository) {
        CustomerEntityListener.customerHistoryRepository = customerHistoryRepository;
    }

    @PostPersist
    public void savedToCustomerHistory(CustomerEntity customerEntity) {
        customerHistoryRepository.save(customerEntity.tocustomerHistoryEntityAfterSave());
    }
    @PreUpdate
    public void updatedToCustomerHistory(CustomerEntity customerEntity){
        customerHistoryRepository.save(customerEntity.tocustomerHistoryEntityAfterUpdate());
    }
}
