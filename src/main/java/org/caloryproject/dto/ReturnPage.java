package org.caloryproject.dto;


import lombok.Builder;

import java.util.List;

@Builder
public class ReturnPage {
    private Integer currentPage;
    private Integer allPages;
    private List<ExerciseDto> content;


//    @Override
//    public String toString() {
//        return  "currentPage : " + currentPage +
//                ", allPages : " + allPages +
//                "," + content +
//                '}';
//    }
}
