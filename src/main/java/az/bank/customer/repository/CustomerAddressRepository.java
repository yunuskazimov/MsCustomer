package az.bank.customer.repository;

import az.bank.customer.dao.CustomerAddressEntity;
import az.bank.customer.dao.CustomerContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity,Long> {
    CustomerAddressEntity findByCustomerId(Long customerId);
}
