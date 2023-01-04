package com.fatma.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatma.gestiondestock.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
