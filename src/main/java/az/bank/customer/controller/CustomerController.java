package az.bank.customer.controller;


import az.bank.customer.service.CustomerService;
import az.bank.customer.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import az.bank.customer.model.CustomerDto;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto dto) {
        return new ResponseEntity<>(customerService.createCustomer(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }

    @PutMapping("/{id}")
    public CustomerDto editCustomer(@RequestBody CustomerDto dto,
                                    @PathVariable Long id) {
        dto.setId(id);
        return customerService.editCustomer(dto);
    }

    @PatchMapping("/{id}")
    public CustomerDto editCustomerSomeData(@RequestBody CustomerDto dto,
                                            @PathVariable Long id) {
        dto.setId(id);
        return customerService.editCustomerSomeData(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deteleCustomer(id);
    }

//    @PostMapping("/migration/{id}")
//    public CustomerDto migrateCustomer(@PathVariable Long id){
//        return customerService.migrateCustomer(id);
//    }

}
