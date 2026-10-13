package com.mkobya.employment_management_system.serviceImpl;

import com.mkobya.employment_management_system.modal.Employee;
import com.mkobya.employment_management_system.payload.requestDto.EmployeeDto;
import com.mkobya.employment_management_system.payload.responseDto.EmployeeResponseDto;
import com.mkobya.employment_management_system.repository.EmployeeRepository;
import com.mkobya.employment_management_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDto createEmployee(EmployeeDto employeeDto) {

        String name = employeeDto.getName();
        String age = employeeDto.getAge();
        String email = employeeDto.getEmail();

        Employee employee = new Employee();
        employee.setAge(age);
        employee.setEmail(email);
        employee.setName(name);

        Employee savedEmployee = employeeRepository.save(employee);

        return getEmployeeResponseDto(savedEmployee);
    }

    @Override
    public EmployeeResponseDto findEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    private static EmployeeResponseDto getEmployeeResponseDto(Employee employee){
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setAge(employee.getAge());
        dto.setEmail(employee.getEmail());
        dto.setName(employee.getName());
        dto.setId(employee.getId());

        return dto;
    }
}
