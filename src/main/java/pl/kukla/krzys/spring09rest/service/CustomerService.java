package pl.kukla.krzys.spring09rest.service;

import pl.kukla.krzys.spring09rest.domain.Customer;
import pl.kukla.krzys.spring09rest.web.model.CustomerDto;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
public interface CustomerService {

    List<CustomerDto> findAll();

    CustomerDto findById(Long id);

    Customer createCustomer(CustomerDto customerDto);

}
