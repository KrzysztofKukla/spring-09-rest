package pl.kukla.krzys.spring09rest.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kukla.krzys.spring09rest.domain.Category;
import pl.kukla.krzys.spring09rest.repository.CategoryRepository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Krzysztof Kukla
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryLoaderBootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            Category cat1 = Category.builder().name("first").build();
            Category cat2 = Category.builder().name("second").build();
            Category cat3 = Category.builder().name("third").build();

            List<Category> categories = Arrays.asList(cat1, cat2, cat3);

            categoryRepository.saveAll(categories);

        }

    }

}
