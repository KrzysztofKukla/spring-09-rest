package pl.kukla.krzys.spring09rest.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.kukla.krzys.spring09rest.domain.Customer;
import pl.kukla.krzys.spring09rest.service.CustomerService;
import pl.kukla.krzys.spring09rest.web.model.CustomerDto;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author Krzysztof Kukla
 */
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void addCustomer() throws Exception {
        String firstName = "first";
        String lastName = "last";
        CustomerDto customerDto = CustomerDto.builder().firstName(firstName).lastName(lastName).build();
        Customer savedCustomer = Customer.builder().firstName(firstName).lastName(lastName).build();

        BDDMockito.when(customerService.createCustomer(customerDto)).thenReturn(savedCustomer);

        String customerContent = new ObjectMapper().writeValueAsString(customerDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/customers")
            .content(customerContent)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated());

        BDDMockito.then(customerService).should().createCustomer(any(CustomerDto.class));
    }

}