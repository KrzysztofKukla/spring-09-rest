package pl.kukla.krzys.spring09rest.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Krzysztof Kukla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @JsonProperty("customer_url")
    private String customerUrl;

}
