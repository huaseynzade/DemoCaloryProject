package org.caloryproject.repository;

import org.caloryproject.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findAll();
}
