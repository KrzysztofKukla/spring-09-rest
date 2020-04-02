package pl.kukla.krzys.spring09rest.web.mapper;

import org.mapstruct.Mapper;
import pl.kukla.krzys.spring09rest.domain.Category;
import pl.kukla.krzys.spring09rest.web.model.CategoryDto;

/**
 * @author Krzysztof Kukla
 */
//declare class as Spring Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category categoryDtoToCategory(CategoryDto categoryDto);

    CategoryDto categoryToCategoryDto(Category category);

}
