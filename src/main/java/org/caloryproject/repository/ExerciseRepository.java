package org.caloryproject.repository;

import org.caloryproject.entity.CategoryEntity;
import org.caloryproject.entity.ExercisesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends CrudRepository<ExercisesEntity, Integer> {
    Page<ExercisesEntity> getAllByCategory(CategoryEntity category, Pageable pageable);
    Optional<ExercisesEntity> findByNameContainsIgnoreCase(String name);

    List<ExercisesEntity> findByEquipment(String equipment);

    List<ExercisesEntity> findByDuration(Double duration);




}
