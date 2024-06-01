package org.caloryproject.controlles;

import lombok.RequiredArgsConstructor;
import org.caloryproject.dto.CategoryDto;
import org.caloryproject.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public void createCategory(@RequestBody CategoryDto categoryDto){
        categoryService.createCategory(categoryDto);
    }

}
