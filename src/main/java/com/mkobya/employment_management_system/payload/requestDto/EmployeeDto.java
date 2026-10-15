package com.mkobya.employment_management_system.payload.requestDto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String age;
    private String email;
    private Long department_id;
    private String departmentName;
}
