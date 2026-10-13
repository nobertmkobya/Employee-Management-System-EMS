package com.mkobya.employment_management_system.controller;


import com.mkobya.employment_management_system.payload.requestDto.EmployeeDto;
import com.mkobya.employment_management_system.payload.responseDto.EmployeeResponseDto;
import com.mkobya.employment_management_system.service.DepartmentService;
import com.mkobya.employment_management_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor

public class EmployeeController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDto> createDepartment(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
    }
}
