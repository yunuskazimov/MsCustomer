package az.bank.customer.repository;

import az.bank.customer.dao.CustomerAddressEntity;
import az.bank.customer.dao.CustomerContactsEntity;
import az.bank.customer.dao.CustomerHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContactsEntity,Long> {
    List<CustomerContactsEntity> findByCustomerId(Long customerId);
}
