package az.bank.customer.service;

import az.bank.customer.dao.CustomerContactsEntity;
import az.bank.customer.dao.CustomerEntity;
import az.bank.customer.mapper.CustomerAddressMapper;
import az.bank.customer.mapper.CustomerContactMapper;
import az.bank.customer.mapper.CustomerMapper;
import az.bank.customer.model.CustomerDto;
import az.bank.customer.repository.CustomerAddressRepository;
import az.bank.customer.repository.CustomerContactRepository;
import az.bank.customer.repository.CustomerRepository;
import az.bank.customer.util.CustomerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerUtil customerUtil;
    private final CustomerRepository customerRepository;
    private final CustomerContactRepository customerContactRepository;
    private final CustomerAddressRepository customerAddressRepository;

    public CustomerServiceImpl(CustomerUtil customerUtil,
                               CustomerRepository customerRepository,
                               CustomerContactRepository customerContactRepository,
                               CustomerAddressRepository customerAddressRepository) {
        this.customerUtil = customerUtil;
        this.customerRepository = customerRepository;
        this.customerContactRepository = customerContactRepository;
        this.customerAddressRepository = customerAddressRepository;

    }


    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        CustomerEntity entity = customerRepository.save(CustomerMapper.dtoToEntity(dto));
        dto.setId(entity.getId());
        customerContactRepository.saveAll(CustomerContactMapper.toEntites(entity, dto.getContacts()));
        customerAddressRepository.save(CustomerAddressMapper.toEntites(entity, dto.getAddress()));

        return dto;
    }

    @Override
    public CustomerDto editCustomer(CustomerDto dto) {
        //TODO add adress and contact changes
        customerUtil.findCustomer(dto.getId());

        CustomerEntity entity = CustomerMapper.dtoToEntity(dto);
        entity.setId(dto.getId());
        customerRepository.save(entity);
        return dto;
    }

    @Override
    public CustomerDto editCustomerSomeData(CustomerDto dto) {
        //TODO add adress and contact changes
        CustomerEntity entity = customerUtil.findCustomer(dto.getId());

        CustomerMapper.toEntityWithCheck(entity, dto);
        entity.setId(dto.getId());
        customerRepository.save(entity);
        return CustomerMapper.entityToDto(entity);
    }

    @Override
    public CustomerDto getCustomer(Long id) {

        CustomerDto customerDto = CustomerMapper.entityToDto(customerRepository.findById(id).get());
        customerDto.setAddress(CustomerAddressMapper.toDto(customerAddressRepository.findByCustomerId(id)));

        List<CustomerContactsEntity> contactsEntities = customerContactRepository.findByCustomerId(id);
        customerDto.setContacts(CustomerContactMapper.toDtos(contactsEntities));

        return customerDto;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<CustomerDto> customerDtos = CustomerMapper.entitiesToDtos(customerRepository.findAll());
        customerDtos.forEach(dto -> dto.setAddress(
                CustomerAddressMapper.toDto(customerAddressRepository.findByCustomerId(dto.getId()))));
        customerDtos.forEach(dto1 -> {
            dto1.setContacts(
                    CustomerContactMapper.toDtos(customerContactRepository.findByCustomerId(dto1.getId())));
        });
        return customerDtos;
    }

    @Override
    public void deteleCustomer(Long id) {
        //TODO add adress and contact changes
        customerUtil.findCustomer(id);
        customerRepository.deleteById(id);
    }

//    @Override
//    public CustomerDto migrateCustomer(Long id) {
//        return CustomerMapper.entityToDto(
//                customerRepository.save(CustomerMapper.toEntity(customerClient.getCustomer(id))
//                ));
//    }

}
