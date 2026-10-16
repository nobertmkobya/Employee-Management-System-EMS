package com.mkobya.employment_management_system.controller;


import com.mkobya.employment_management_system.modal.Department;
import com.mkobya.employment_management_system.payload.requestDto.DepartmentDto;
import com.mkobya.employment_management_system.payload.responseDto.DepartmentResponseDto;
import com.mkobya.employment_management_system.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor

public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<DepartmentResponseDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.createDepartment(departmentDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        departmentService.deleteById(id);
    }
}
