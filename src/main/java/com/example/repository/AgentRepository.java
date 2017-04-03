package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Agent;

public interface  AgentRepository extends JpaRepository <Agent,Long> {

}
