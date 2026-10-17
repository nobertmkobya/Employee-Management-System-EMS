package com.mkobya.employment_management_system.service;

import com.mkobya.employment_management_system.modal.Employee;
import com.mkobya.employment_management_system.payload.requestDto.EmployeeDto;
import com.mkobya.employment_management_system.payload.responseDto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto createEmployee (EmployeeDto employeeDto);

    EmployeeResponseDto findEmployeeById (Long id);

    List<EmployeeResponseDto> listAllEmployees();

    void deleteById(Long id);
}
