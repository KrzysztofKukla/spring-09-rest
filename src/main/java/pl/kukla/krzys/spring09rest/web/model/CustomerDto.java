package pl.kukla.krzys.spring09rest.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Krzysztof Kukla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private String firstName;
    private String lastName;
    private String customerUrl;

}
