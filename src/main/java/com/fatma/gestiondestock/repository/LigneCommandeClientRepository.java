package com.fatma.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatma.gestiondestock.model.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

}
