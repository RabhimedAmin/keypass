package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.RessourceService;

import com.example.model.Ressource;
import com.example.repository.RessourceRepository;

@Service
public class RessourceServiceImpl implements RessourceService {
	@Autowired
	private RessourceRepository ressourceRepository;

	@Autowired
	public void setRessourceRepository(RessourceRepository ressourceRepository) {
		this.ressourceRepository = ressourceRepository;
	}

	@Override
	public Ressource createRessource(Ressource ressource) {
		// TODO Auto-generated method stub
		return ressourceRepository.save(ressource);
	}

	@Override
	public List<Ressource> getAllRessources() {
		// TODO Auto-generated method stub
		return ressourceRepository.findAll();
	}

	@Override
	public Ressource modifyRessource(Ressource ressource) {
		// TODO Auto-generated method stub
		return ressourceRepository.save(ressource);
	}

	@Override
	public Ressource getRessource(long id) {
		// TODO Auto-generated method stub
		return ressourceRepository.findOne(id);
	}

	@Override
	public void deleteRessource(long id) {
		// TODO Auto-generated method stub
		ressourceRepository.delete(id);
	}

}
