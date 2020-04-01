package pl.kukla.krzys.spring09rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kukla.krzys.spring09rest.domain.Category;

/**
 * @author Krzysztof Kukla
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
