package com.personal.system.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignatureDto {
    private Long id;
    private String name;
    private List<AssignatureCourseDto> assignatureCourses;
}
