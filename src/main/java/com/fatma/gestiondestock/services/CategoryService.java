package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.CategoryDto;

public interface CategoryService {

	CategoryDto save(CategoryDto categoryDto);

	CategoryDto findById(Integer id);

	List<CategoryDto> findAll();

	void delete(Integer id);
}
