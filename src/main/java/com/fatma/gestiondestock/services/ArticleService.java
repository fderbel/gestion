package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.ArticleDto;

public interface ArticleService {

	ArticleDto save(ArticleDto articleDto);

	ArticleDto findById(Integer id);

	ArticleDto findByCodeArticle(String code);

	List<ArticleDto> findAll();

	void delete(Integer id);
}
