package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe,Long> {

}
