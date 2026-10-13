package com.mkobya.employment_management_system.repository;

import com.mkobya.employment_management_system.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
