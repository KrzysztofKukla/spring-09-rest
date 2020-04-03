package pl.kukla.krzys.spring09rest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.spring09rest.domain.Customer;
import pl.kukla.krzys.spring09rest.exception.CustomerNotFoundException;
import pl.kukla.krzys.spring09rest.repository.CustomerRepository;
import pl.kukla.krzys.spring09rest.web.mapper.CustomerMapper;
import pl.kukla.krzys.spring09rest.web.model.CustomerDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Kukla
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
            .map(customer -> customerMapper.customerToCustomerDto(customer))
            .collect(Collectors.toList());
    }

    @Override
    public CustomerDto findById(Long id) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException("Cannot find customer for id->" + id));
        return customerMapper.customerToCustomerDto(customer);
    }

}
