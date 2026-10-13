package com.mkobya.employment_management_system.payload.requestDto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Long id;
    private String name;
    private String description;
    private String code;
}
