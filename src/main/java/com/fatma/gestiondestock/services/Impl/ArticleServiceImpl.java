package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.ArticleDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.exception.InvalidEntityException;
import com.fatma.gestiondestock.mapper.ArticleDtoArticleMapper;
import com.fatma.gestiondestock.model.Article;
import com.fatma.gestiondestock.repository.ArticleRepository;
import com.fatma.gestiondestock.services.ArticleService;
import com.fatma.gestiondestock.validator.ArticleValidator;

import lombok.extern.slf4j.Slf4j;

@Service("articleServiceImpl1")
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	private ArticleRepository articleRepository;

	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public ArticleDto save(ArticleDto articleDto) {
		List<String> errors = ArticleValidator.validate(articleDto);
		if (!errors.isEmpty()) {
			log.error("article not valide {}", articleDto);
			throw new InvalidEntityException("article n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
		}
		return ArticleDtoArticleMapper.INSTANCE.articleToArticleDto(
				articleRepository.save(ArticleDtoArticleMapper.INSTANCE.articleDtoToArticle(articleDto)));

	}

	@Override
	public ArticleDto findById(Integer id) {
		if (id == null) {
			log.error("Article ID est null");
			return null;
		}
		Optional<Article> article = articleRepository.findById(id);
		return Optional.of(ArticleDtoArticleMapper.INSTANCE.articleToArticleDto(article.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public ArticleDto findByCodeArticle(String code) {
		if (code == null) {
			log.error("Article ID est null");
			return null;

		}
		Optional<Article> article = articleRepository.findByCode(code);
		return Optional.of(ArticleDtoArticleMapper.INSTANCE.articleToArticleDto(article.get())).orElseThrow(
				() -> new EntityNotFoundException("article not found with code ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleRepository.findAll().stream().map(ArticleDtoArticleMapper.INSTANCE::articleToArticleDto)
				.collect(Collectors.toList());

	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Article ID est null");
			return;

		}
		articleRepository.deleteById(id);
	}

}
