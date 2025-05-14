package com.Api.Livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Api.Livraria.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
