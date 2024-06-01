package org.caloryproject.services;

import lombok.RequiredArgsConstructor;
import org.caloryproject.dto.CategoryDto;
import org.caloryproject.entity.CategoryEntity;
import org.caloryproject.map.CategoryMap;
import org.caloryproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMap map;

    public List<CategoryDto> getAll(){
        return repository.findAll().stream().map(map::toDto).toList();
    }

    public void createCategory(CategoryDto categoryDto){
        repository.save(map.toEntity(categoryDto));
    }


}
