package org.caloryproject.controlles;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.caloryproject.services.PracticeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practice")
@RequiredArgsConstructor
public class PracticeController {

    private final PracticeService service;

    @PostMapping("/{exerciseId}/duration/{duration}")
    public void training(HttpServletRequest request, @PathVariable Integer exerciseId,@PathVariable Double duration) {
        service.training(request, exerciseId, duration);
    }

    @GetMapping("/current-weight/")
    public String currentWeight(Integer calorieInTake, HttpServletRequest request){
        return service.currentWeight(calorieInTake,request);
    }

    @GetMapping("/weekly/")
    public Double getTotalBurnCalories(HttpServletRequest request) {
        return service.getWeeklyBurnCalories(request);
    }



}
