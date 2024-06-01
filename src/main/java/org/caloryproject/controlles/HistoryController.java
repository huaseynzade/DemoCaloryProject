package org.caloryproject.controlles;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.caloryproject.dto.HistoryDto;
import org.caloryproject.services.UserHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {
    private final UserHistoryService service;


    @GetMapping
    public List<HistoryDto> findUserHistory(HttpServletRequest request) {
        return service.findUserHistory(request);
    }





}
