package com.fatma.gestiondestock.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fatma.gestiondestock.dto.ArticleDto;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.exception.InvalidEntityException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

	@Autowired
	@Qualifier("articleServiceImpl1")
	private ArticleService articleService;

	@Test
	void shouldSaveArticleWithSuccess() {

		ArticleDto expectedArticle = ArticleDto.builder().code("code").designation("designation")
				.prixUnitaireHt(new BigDecimal(42)).prixUnitairettc(new BigDecimal(142)).tauxTva(new BigDecimal(42))
				.build();

		ArticleDto savedArticle = articleService.save(expectedArticle);
		assertNotNull(savedArticle);
		assertNotNull(savedArticle.getId());
		assertEquals(expectedArticle.getCode(), savedArticle.getCode());

	}

	@Test
	void shouldSaveArticleWithExceptionInvalid() {
		ArticleDto expectedArticle = ArticleDto.builder().build();

		InvalidEntityException expectedException = assertThrows(InvalidEntityException.class,
				() -> articleService.save(expectedArticle));

		assertEquals(ErrorCodes.ARTICLE_NOT_VALID, expectedException.getErrorCode());
		assertEquals(expectedException.getErrors().size(), 4);
	}

}
