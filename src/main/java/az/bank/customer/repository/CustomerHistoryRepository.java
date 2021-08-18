package az.bank.customer.repository;

import az.bank.customer.dao.CustomerEntity;
import az.bank.customer.dao.CustomerHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerHistoryRepository extends JpaRepository<CustomerHistoryEntity,Long> {

}
