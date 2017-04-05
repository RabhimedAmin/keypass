package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Service.DemandeService;
import com.example.model.Demande;
import com.example.repository.DemandeRepository;

public class DemandeServiceImpl implements DemandeService {

	@Autowired
	public void setdemandeRepository(DemandeRepository demandeRepository) {
		this.demandeRepository = demandeRepository;
	}

	@Autowired
	DemandeRepository demandeRepository;

	@Override
	public void deleteDemande(long id) {
		// TODO Auto-generated method stub
		demandeRepository.delete(id);
	}

	@Override
	public Demande getDemande(long id) {
		// TODO Auto-generated method stub
		return demandeRepository.findOne(id);
	}

	@Override
	public List<Demande> getAllDemandes() {
		// TODO Auto-generated method stub
		return demandeRepository.findAll();
	}

	@Override
	public Demande modifydemande(Demande demande) {
		// TODO Auto-generated method stub
		return demandeRepository.save(demande);
	}

	@Override
	public Demande createdemande(Demande demande) {
		// TODO Auto-generated method stub
		return demandeRepository.save(demande);
	}

}
