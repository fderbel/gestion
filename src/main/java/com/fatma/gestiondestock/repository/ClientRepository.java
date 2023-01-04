package com.fatma.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatma.gestiondestock.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
