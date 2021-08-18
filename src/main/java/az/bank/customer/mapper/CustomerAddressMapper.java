package az.bank.customer.mapper;

import az.bank.customer.dao.CustomerAddressEntity;
import az.bank.customer.dao.CustomerEntity;
import az.bank.customer.model.AddressDto;
import az.bank.customer.model.CustomerDto;

public class CustomerAddressMapper {

    public static CustomerAddressEntity toEntites(CustomerEntity entity, AddressDto addressDto) {
        CustomerAddressEntity addressEntity = new CustomerAddressEntity();

        addressEntity.setCustomer(entity);
        addressEntity.setId(addressDto.getId());
        addressEntity.setCity(addressDto.getCity());
        addressEntity.setCountry(addressDto.getCountry());
        addressEntity.setStreet(addressDto.getStreet());

        return addressEntity;
    }

    public static AddressDto toDto(CustomerAddressEntity addressEntity){
      return AddressDto.builder()
                        .city(addressEntity.getCity())
                        .country(addressEntity.getCountry())
                        .id(addressEntity.getId())
                        .street(addressEntity.getStreet())
                        .build();
    }
}
