package com.satoruakiyama.employmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satoruakiyama.employmanagementsystem.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
