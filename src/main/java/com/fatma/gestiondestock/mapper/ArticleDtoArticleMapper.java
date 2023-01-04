package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.ArticleDto;
import com.fatma.gestiondestock.model.Article;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface ArticleDtoArticleMapper {
	ArticleDtoArticleMapper INSTANCE = Mappers.getMapper(ArticleDtoArticleMapper.class);

	Article articleDtoToArticle(ArticleDto articleDto);

	ArticleDto articleToArticleDto(Article article);

}
