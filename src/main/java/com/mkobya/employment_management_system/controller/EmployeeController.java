package com.mkobya.employment_management_system.controller;


import com.mkobya.employment_management_system.payload.requestDto.EmployeeDto;
import com.mkobya.employment_management_system.payload.responseDto.EmployeeResponseDto;
import com.mkobya.employment_management_system.service.DepartmentService;
import com.mkobya.employment_management_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor

public class EmployeeController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeResponseDto> findEmployeeById(@PathVariable Long id ){
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }
}
