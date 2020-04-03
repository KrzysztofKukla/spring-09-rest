package pl.kukla.krzys.spring09rest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kukla.krzys.spring09rest.domain.Customer;
import pl.kukla.krzys.spring09rest.repository.CustomerRepository;
import pl.kukla.krzys.spring09rest.web.mapper.CustomerMapper;
import pl.kukla.krzys.spring09rest.web.model.CustomerDto;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author Krzysztof Kukla
 */
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void createCustomer() {
        String firstName = "first Name";
        String lastName = "first lastName";
        CustomerDto customerDto = CustomerDto.builder().firstName(firstName).lastName(lastName).build();
        Customer customer = Customer.builder().firstName(firstName).lastName(lastName).build();

        BDDMockito.when(customerMapper.customerDtoToCustomer(any(CustomerDto.class))).thenReturn(customer);
        BDDMockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.createCustomer(customerDto);

        Assertions.assertEquals(customer, savedCustomer);
        Assertions.assertEquals(customer.getLastName(), savedCustomer.getLastName());
        BDDMockito.then(customerMapper).should().customerDtoToCustomer(any(CustomerDto.class));
        BDDMockito.then(customerRepository).should().save(any(Customer.class));

    }

}