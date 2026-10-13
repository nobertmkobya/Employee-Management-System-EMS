package com.mkobya.employment_management_system.serviceImpl;

import com.mkobya.employment_management_system.modal.Department;
import com.mkobya.employment_management_system.payload.requestDto.DepartmentDto;
import com.mkobya.employment_management_system.payload.responseDto.DepartmentResponseDto;
import com.mkobya.employment_management_system.repository.DepartmentRepository;
import com.mkobya.employment_management_system.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentDto departmentDto) {
        log.info("Creating Department");
        String name = departmentDto.getName();
        String description = departmentDto.getDescription();
        String code = departmentDto.getCode();

        Department department = new Department();
        department.setCode(code);
        department.setName(name);
        department.setDescription(description);

        Department savedDepartment = departmentRepository.save(department);


        return getDepartmentResponseDto(savedDepartment);
    }

    @Override
    public DepartmentResponseDto findById(Long id) {
        log.info("Get Department by Id");
        Department retrievedDepartment=departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department Not Found"));

        return getDepartmentResponseDto(retrievedDepartment);
    }

    @Override
    public List<Department> findAll() {
        log.info("Get All Departments");
        return departmentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting Department by Id");
        Department retrievedDepartment=departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department Not Found"));
        //hard delete
//        departmentRepository.delete(retrievedDepartment);

        //soft delete
        retrievedDepartment.setDeleted(true);
        retrievedDepartment.setActive(false);
        departmentRepository.save(retrievedDepartment);
    }

    private static DepartmentResponseDto getDepartmentResponseDto(Department department){
        DepartmentResponseDto dto = new DepartmentResponseDto();
        dto.setName(department.getName());
        dto.setCode(department.getCode());
        dto.setDescription(department.getDescription());
        dto.setId(department.getId());
        return dto;
    }
}
