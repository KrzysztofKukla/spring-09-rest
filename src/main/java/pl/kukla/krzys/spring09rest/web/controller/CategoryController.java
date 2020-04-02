package pl.kukla.krzys.spring09rest.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.spring09rest.service.CategoryService;
import pl.kukla.krzys.spring09rest.web.model.CategoryDto;
import pl.kukla.krzys.spring09rest.web.model.CategoryListDto;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<CategoryListDto> getAll() {
        List<CategoryDto> categories = categoryService.getAll();
        CategoryListDto categoryListDto = CategoryListDto.builder().categories(categories).build();
        return ResponseEntity.ok(categoryListDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        CategoryDto categoryDto = categoryService.getById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryDto> getByName(@PathVariable String name) {
        CategoryDto categoryDto = categoryService.getByName(name);
        return ResponseEntity.ok(categoryDto);
    }

}
