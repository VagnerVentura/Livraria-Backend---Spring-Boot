package com.Api.Livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Livraria.dto.SaleDto;
import com.Api.Livraria.entities.Employee;
import com.Api.Livraria.entities.Sale;
import com.Api.Livraria.services.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RequestMapping("/employees")
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee ){
		return ResponseEntity.ok(employeeService.createEmployee(employee)); 
	}
	
//	@PostMapping
//	public ResponseEntity<Sale> sellBook(SaleDto sale){
//		return ResponseEntity.ok(employeeService.sellBook(sale));
//	}
	
}
