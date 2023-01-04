package com.fatma.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatma.gestiondestock.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
