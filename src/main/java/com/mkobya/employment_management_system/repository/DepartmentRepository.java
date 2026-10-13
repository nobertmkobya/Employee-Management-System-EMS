package com.mkobya.employment_management_system.repository;

import com.mkobya.employment_management_system.modal.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
