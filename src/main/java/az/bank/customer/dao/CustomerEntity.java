package az.bank.customer.dao;

import az.bank.customer.model.TitleType;
import az.bank.customer.shared.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
@EntityListeners(CustomerEntityListener.class)
@Builder
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private TitleType title;
    private LocalDate birthDate;
    @OneToMany(mappedBy = "customer")
    private List<CustomerContactsEntity> customerContacts;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;


    CustomerHistoryEntity tocustomerHistoryEntityAfterSave() {
        return CustomerHistoryEntity.builder()
                .customer(this)
                .birthDate(this.getBirthDate())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .note("Account Created")
                .build();
    }

    CustomerHistoryEntity tocustomerHistoryEntityAfterUpdate() {
        return CustomerHistoryEntity.builder()
                .customer(this)
                .birthDate(this.getBirthDate())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .note("Account Updated")
                .build();
    }
}
