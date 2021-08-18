package az.bank.customer.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private TitleType title;
    private LocalDate birthDate;
    private Map<ContactType,String> contacts;
    private AddressDto address;

}
