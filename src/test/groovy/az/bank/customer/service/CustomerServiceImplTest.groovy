package az.bank.customer.service

import az.bank.customer.dao.CustomerEntity
import az.bank.customer.mapper.CustomerMapper
import az.bank.customer.model.AddressDto
import az.bank.customer.model.ContactType
import az.bank.customer.model.CustomerDto
import az.bank.customer.repository.CustomerAddressRepository
import az.bank.customer.repository.CustomerContactRepository
import az.bank.customer.repository.CustomerRepository
import az.bank.customer.util.CustomerUtil
import spock.lang.Specification

import java.time.LocalDate

class CustomerServiceImplTest extends Specification {
    private CustomerUtil customerUtil
    private CustomerRepository customerRepository
    private CustomerContactRepository contactRepository
    private CustomerAddressRepository addressRepository
    private CustomerService customerService

    def setup() {
        customerUtil = Mock()
        customerRepository = Mock()
        contactRepository = Mock()
        addressRepository = Mock()
        customerService = new CustomerServiceImpl(
                customerUtil,
                customerRepository,
                contactRepository,
                addressRepository
        )
    }

    def "customerCreate success"() {
        given:
        def customerDto = new CustomerDto()
        customerDto.firstName = "Yunus"
        customerDto.lastName = "Kazimov"
        customerDto.birthDate = LocalDate.of(2000, 01, 13)
        customerDto.title = "MR"
        Map<ContactType, String> maps = new HashMap<>()
        maps.put(ContactType.EMAIL, "yunus.kazimov@gmail.com")
        maps.put(ContactType.PHONE, "+994776011222")
        customerDto.contacts = maps
        customerDto.address = AddressDto.builder()
                .city("Baku")
                .country("Azerbaijan")
                .street("Ehmed Recebli")
                .build()


        println "DTO : " + customerDto

        def entityPreSave = CustomerMapper.dtoToEntity(customerDto)
        println "PreSave : " + entityPreSave
        def entityPostSave = CustomerMapper.dtoToEntity(customerDto)
        entityPostSave.id = 12
        println "PostSave : " + entityPostSave
        when:
        def actual = customerService.createCustomer(customerDto)

        then:
        1 * customerRepository.save(entityPreSave) >> entityPostSave

        actual.id == 12
    }
}
