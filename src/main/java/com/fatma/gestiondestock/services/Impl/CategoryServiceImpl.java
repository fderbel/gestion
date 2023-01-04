package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.CategoryDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.mapper.CategoryDtoCategoryMapper;
import com.fatma.gestiondestock.model.Category;
import com.fatma.gestiondestock.repository.CategoryRepository;
import com.fatma.gestiondestock.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		return CategoryDtoCategoryMapper.INSTANCE.categoryToCategoryDto(
				categoryRepository.save(CategoryDtoCategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto)));

	}

	@Override
	public CategoryDto findById(Integer id) {
		if (id == null) {
			log.error("Category ID est null");
			return null;
		}
		Optional<Category> category = categoryRepository.findById(id);
		return Optional.of(CategoryDtoCategoryMapper.INSTANCE.categoryToCategoryDto(category.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<CategoryDto> findAll() {
		return categoryRepository.findAll().stream().map(CategoryDtoCategoryMapper.INSTANCE::categoryToCategoryDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Category ID est null");
			return;

		}
		categoryRepository.deleteById(id);

	}

}
