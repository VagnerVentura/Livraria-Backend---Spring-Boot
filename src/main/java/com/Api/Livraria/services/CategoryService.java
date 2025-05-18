package com.Api.Livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.Livraria.dto.CategoryDto;
import com.Api.Livraria.entities.Category;
import com.Api.Livraria.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public Category createCategory(CategoryDto dto) {
		Category category = new Category();
		category.setName(dto.getName());
		return categoryRepository.save(category);
	}
		
	public List<Category> createMany(List<CategoryDto> categories) {
		List<Category> saved = categories.stream()
				.map(dto -> createCategory(dto))
				.toList();
		return saved;
	}
	
	public Category findCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(()-> new RuntimeException("Category not Found!"));
	}
	
	public List<Category> findCategoriesById(List<Long> id) {
		List<Category> categories = categoryRepository.findAllById(id);
		return categories;
	}

	
}
