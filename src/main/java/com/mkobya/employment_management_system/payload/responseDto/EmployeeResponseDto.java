package com.mkobya.employment_management_system.payload.responseDto;

import lombok.Data;

@Data
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private String age;
    private String email;
    private Long department_id;
    private String departmentName;
    private String departmentDescription;
}
