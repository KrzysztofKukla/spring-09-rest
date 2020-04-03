package pl.kukla.krzys.spring09rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Krzysztof Kukla
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
    private String message;

    public CustomerNotFoundException(String message) {
        this.message = message;
    }

}
