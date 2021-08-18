package az.bank.customer.mapper;


import az.bank.customer.dao.CustomerEntity;
import az.bank.customer.model.CustomerDto;

import java.util.List;

public class CustomerMapper {

    //TODO add method for update
    public static CustomerEntity dtoToEntity(CustomerDto dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setTitle(dto.getTitle());
        return entity;
    }

    public static void toEntityWithCheck(CustomerEntity entity, CustomerDto dto) {
        if (!entity.getFirstName().equals(dto.getFirstName())) entity.setFirstName(dto.getFirstName());
        if (!entity.getLastName().equals(dto.getLastName())) entity.setLastName(dto.getLastName());
        if (!entity.getBirthDate().equals(dto.getBirthDate())) entity.setBirthDate(dto.getBirthDate());
        if (!entity.getTitle().equals(dto.getTitle())) entity.setTitle(dto.getTitle());

    }

    public static CustomerDto entityToDto(CustomerEntity entity) {
        CustomerDto dto = new CustomerDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthDate(entity.getBirthDate());
        dto.setTitle(entity.getTitle());
        return dto;
    }

    public static List<CustomerDto> entitiesToDtos(List<CustomerEntity> entityList) {
        List<CustomerDto> dtoList = entityList
                .stream()
                .map(CustomerMapper::entityToDto)
                .toList();
        return dtoList;
    }
}
