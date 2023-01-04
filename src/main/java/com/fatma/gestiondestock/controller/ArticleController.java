package com.fatma.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatma.gestiondestock.dto.ArticleDto;
import com.fatma.gestiondestock.services.ArticleService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "javainuseapi")
//@RequestMapping("/v1/gestionStock")
public class ArticleController {

	@Autowired
	@Qualifier("articleServiceImpl1")
	ArticleService articleService;

	// @ApiOperation(value = "save or modifier article", response =
	// ArticleDto.class)
	// @ApiResponses(value = { @ApiResponse(code = 201, message = "article inserted
	// successfully"),
	// @ApiResponse(code = 400, message = "Ops...something went wrong with your
	// request") })
	@PostMapping(value = "/article")

	ArticleDto save(@RequestBody ArticleDto articleDto) {
		return articleService.save(articleDto);
	}

	// @ApiOperation(value = "get article with id", response = ArticleDto.class)
	@GetMapping(value = "/article/{id}")

	ArticleDto findById(@PathVariable("id") Integer id) {
		return articleService.findById(id);
	}

	// @ApiOperation(value = "get article with code", response = ArticleDto.class)
	@GetMapping(value = "/article/code/{code}")
	ArticleDto findByCodeArticle(@PathVariable String code) {
		return articleService.findByCodeArticle(code);
	}

	// @ApiOperation(value = "get all articles", responseContainer = "LIST OF
	// ArticleDto.class")
	@GetMapping(value = "/articles")
	List<ArticleDto> findAll() {
		return articleService.findAll();
	}

	// @ApiOperation(value = "delete article")
	@DeleteMapping(value = "article/{id}")
	void delete(@PathVariable Integer id) {
		articleService.delete(id);
	}
}
