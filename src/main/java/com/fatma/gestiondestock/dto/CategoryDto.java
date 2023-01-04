package com.fatma.gestiondestock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDto {

	private Integer id;
	private String code;
	private String designation;
	// private List<ArticleDto> articles;
}
