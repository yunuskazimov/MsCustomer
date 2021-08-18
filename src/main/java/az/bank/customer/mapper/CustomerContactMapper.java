package az.bank.customer.mapper;

import az.bank.customer.dao.CustomerContactsEntity;
import az.bank.customer.dao.CustomerEntity;
import az.bank.customer.model.ContactType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerContactMapper {
    public static List<CustomerContactsEntity> toEntites(CustomerEntity entity,
                                                         Map<ContactType, String> contacts) {
        List<CustomerContactsEntity> result = new ArrayList<>();
        contacts.forEach((t, v) -> {
            result.add(
                    CustomerContactsEntity.builder()
                            .customer(entity)
                            .type(t)
                            .value(v)
                            .build()
            );
        });
        return result;
    }

    public static Map<ContactType, String> toDtos(List<CustomerContactsEntity> entityList) {
        Map<ContactType, String> contactsMap = new HashMap<>();

        entityList.forEach(entity -> {
            contactsMap.put(entity.getType(), entity.getValue());
        });
        return contactsMap;
    }
}
