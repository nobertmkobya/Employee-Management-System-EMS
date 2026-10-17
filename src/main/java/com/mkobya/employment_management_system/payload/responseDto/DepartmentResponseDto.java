package com.mkobya.employment_management_system.payload.responseDto;

import lombok.Data;

@Data
public class DepartmentResponseDto {
    private Long id;
    private String name;
    private String description;
    private String code;
    private Boolean active;
}
