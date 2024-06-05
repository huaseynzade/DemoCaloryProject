package org.caloryproject.controlles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.caloryproject.dto.ExerciseDto;
import org.caloryproject.dto.ReturnPage;
import org.caloryproject.services.ExerciseService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService service;


    @GetMapping("/all")
    public ResponseEntity<List<ExerciseDto>> findAllByCategory(@RequestParam(defaultValue = "1") Integer categoryId, @RequestParam(defaultValue = "0") Integer page) {
        return service.findAllByCategory(categoryId, page);
    }

    @GetMapping("/equipment/{equipment}")
    public List<ExerciseDto> getExercisesByEquipment(@PathVariable String equipment) {
        return service.getExercisesByEquipment(equipment);
    }

    @GetMapping("/name/{name}")
    public ExerciseDto getExerciseByName(@PathVariable String name) {
        return service.getExerciseByName(name);
    }

    @GetMapping("/duration/{duration}")
    public List<ExerciseDto> getExercisesByDuration(@PathVariable Double duration) {
        return service.getExercisesByDuration(duration);
    }

    @PostMapping
    public void createExercise(@RequestBody ExerciseDto dto){
        service.createExercise(dto);
    }

}
