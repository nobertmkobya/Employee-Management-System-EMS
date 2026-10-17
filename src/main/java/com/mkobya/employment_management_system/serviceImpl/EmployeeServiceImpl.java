package com.mkobya.employment_management_system.serviceImpl;

import com.mkobya.employment_management_system.modal.Department;
import com.mkobya.employment_management_system.modal.Employee;
import com.mkobya.employment_management_system.payload.requestDto.EmployeeDto;
import com.mkobya.employment_management_system.payload.responseDto.EmployeeResponseDto;
import com.mkobya.employment_management_system.repository.DepartmentRepository;
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
    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeResponseDto createEmployee(EmployeeDto employeeDto) {
        Department department = departmentRepository.findById(employeeDto.getDepartment_id())
                .orElseThrow(()->new RuntimeException("No Department"));


        String name = employeeDto.getName();
        String age = employeeDto.getAge();
        String email = employeeDto.getEmail();

        Employee employee = new Employee();
        employee.setAge(age);
        employee.setEmail(email);
        employee.setName(name);
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        return getEmployeeResponseDto(savedEmployee);
    }

    @Override
    public EmployeeResponseDto findEmployeeById(Long id) {

        Employee retrievedEmployee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found"));

        return getEmployeeResponseDto(retrievedEmployee);
    }

    @Override
    public List<EmployeeResponseDto> listAllEmployees() {
        List<Employee> listOfEmployees=employeeRepository.findAll();

        return listOfEmployees.stream()
                .map(this::getEmployeeResponseDto)
                .toList();
    }


    @Override
    public void deleteById(Long id) {


    }

    private EmployeeResponseDto getEmployeeResponseDto(Employee employee){
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setAge(employee.getAge());
        dto.setEmail(employee.getEmail());
        dto.setName(employee.getName());
        dto.setId(employee.getId());

        if (employee.getDepartment() != null) {
            dto.setDepartment_id(employee.getDepartment().getId());
            dto.setDepartmentName(employee.getDepartment().getName());
            dto.setDepartmentDescription(employee.getDepartment().getDescription());
        }

        return dto;
    }
}
