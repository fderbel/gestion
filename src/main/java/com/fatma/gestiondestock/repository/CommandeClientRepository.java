package com.fatma.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatma.gestiondestock.model.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

}
