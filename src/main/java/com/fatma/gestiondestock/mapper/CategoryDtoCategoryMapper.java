package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.CategoryDto;
import com.fatma.gestiondestock.model.Category;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface CategoryDtoCategoryMapper {
	CategoryDtoCategoryMapper INSTANCE = Mappers.getMapper(CategoryDtoCategoryMapper.class);

	Category categoryDtoToCategory(CategoryDto categoryDto);

	CategoryDto categoryToCategoryDto(Category category);

}
