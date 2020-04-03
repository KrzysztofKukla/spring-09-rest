package pl.kukla.krzys.spring09rest.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.kukla.krzys.spring09rest.domain.Customer;
import pl.kukla.krzys.spring09rest.service.CustomerService;
import pl.kukla.krzys.spring09rest.web.model.CustomerDto;
import pl.kukla.krzys.spring09rest.web.model.CustomerListDto;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Krzysztof Kukla
 */
@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private static final String CUSTOMERS_URI = "/v1/customers";

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerListDto> getAll() {
        List<CustomerDto> customers = customerService.findAll();
        CustomerListDto customerList = CustomerListDto.builder().customers(customers).build();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id) {
        CustomerDto customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

        }
        Customer savedCustomer = customerService.createCustomer(customerDto);
        return buildAndReturnResponseEntity(savedCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDto customerDto) {
        Customer updatedCustomer = customerService.updateCustomer(id, customerDto);
        return buildAndReturnResponseEntity(updatedCustomer);
    }

    private ResponseEntity<CustomerDto> buildAndReturnResponseEntity(Customer savedCustomer) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(CUSTOMERS_URI + "/" + savedCustomer.getId()).build();
        return ResponseEntity.created(uriComponents.toUri())
            .build();
    }

}
