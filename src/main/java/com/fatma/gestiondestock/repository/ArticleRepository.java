package com.fatma.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatma.gestiondestock.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	Optional<Article> findByCode(String code);
//	@Query("select a from article where code =: code and designation =: designation ")
//	List<Article> findByCustomQuery(@Param("code") String c, @Param("designation") String d);

//	@Query(value = "select * from article where where code =: code and designation =: designation", nativeQuery = true)
//	List<Article> findByNativeQuery(@Param("code") String c, @Param("designation") String d);

}
