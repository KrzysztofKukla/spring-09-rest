package pl.kukla.krzys.spring09rest.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.spring09rest.service.CustomerService;
import pl.kukla.krzys.spring09rest.web.model.CustomerDto;
import pl.kukla.krzys.spring09rest.web.model.CustomerListDto;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
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

}
