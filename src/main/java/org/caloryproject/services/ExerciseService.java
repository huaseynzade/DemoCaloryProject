package org.caloryproject.services;

import lombok.RequiredArgsConstructor;
import org.caloryproject.dto.ExerciseDto;
import org.caloryproject.dto.ReturnPage;
import org.caloryproject.entity.CategoryEntity;
import org.caloryproject.entity.ExercisesEntity;
import org.caloryproject.exceptions.NotFoundException;
import org.caloryproject.map.ExerciseMap;
import org.caloryproject.repository.CategoryRepository;
import org.caloryproject.repository.ExerciseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository repository;
    private final CategoryRepository categoryRepository;

    private final ExerciseMap map;

    public ResponseEntity<List<ExerciseDto>> findAllByCategory(Integer id, Integer page){
        CategoryEntity category = categoryRepository.findById(id).orElseThrow();
        Pageable pageable = PageRequest.of(page,3);
        Page<ExerciseDto> pageDto = repository.getAllByCategory(category,pageable).map(map::toDto);
        HashMap<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("Total Pages : ", pageDto.getTotalPages() - 1);
        mapResponse.put("Current Page : ", pageDto.getNumber());
        mapResponse.put("Content : ", pageDto.getContent());
        return (ResponseEntity<List<ExerciseDto>>) new ResponseEntity(mapResponse, HttpStatus.OK);
    }

    public ExerciseDto getExerciseByName(String name){
        ExercisesEntity entity = repository.findByNameContainsIgnoreCase(name).orElseThrow(() -> new NotFoundException("Workout not found"));
        return map.toDto(entity);
    }

    public List<ExerciseDto> getExercisesByEquipment(String equipment){
        List<ExercisesEntity> exercisesEntities = repository.findByEquipment(equipment);
        return exercisesEntities.stream().map(map::toDto).toList();
    }

    public List<ExerciseDto> getExercisesByDuration(Double duration){
        List<ExercisesEntity> entities = repository.findByDuration(duration);
        return entities.stream().map(map::toDto).toList();
    }

    public void createExercise(ExerciseDto dto){
        repository.save(map.toEntity(dto));
    }


}
