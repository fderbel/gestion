package com.fatma.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatma.gestiondestock.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}
