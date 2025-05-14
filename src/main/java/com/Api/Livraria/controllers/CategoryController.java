package com.Api.Livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Livraria.dto.CategoryDto;
import com.Api.Livraria.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto){
		var entity = categoryService.createCategory(dto);
		CategoryDto category = new CategoryDto(entity.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<?> createMany(@RequestBody List<CategoryDto> categories){
		var newCategories = categoryService.createMany(categories);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCategories);
	}
	
}
