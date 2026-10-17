package com.mkobya.employment_management_system.service;

import com.mkobya.employment_management_system.modal.Department;
import com.mkobya.employment_management_system.payload.requestDto.DepartmentDto;
import com.mkobya.employment_management_system.payload.responseDto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentDto departmentDto);

    DepartmentResponseDto findById(Long id);

    List<DepartmentResponseDto> findAll();

    void deleteById(Long id);
}
