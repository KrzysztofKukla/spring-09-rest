package pl.kukla.krzys.spring09rest.exception;

import lombok.RequiredArgsConstructor;

/**
 * @author Krzysztof Kukla
 */
@RequiredArgsConstructor
public class CategoryNotFoundException extends RuntimeException {

    private final String message;

}
