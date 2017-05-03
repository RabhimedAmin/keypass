package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.Service.DemandeService;
import com.example.model.Agent;
import com.example.model.Demande;
import com.example.model.Ressource;
import com.example.repository.AgentRepository;
import com.example.repository.DemandeRepository;
import com.example.repository.RessourceRepository;

@Service("demandeService")
public class DemandeServiceImpl implements DemandeService {

	@Autowired
	DemandeRepository demandeRepository;
	
	@Autowired
	private AgentRepository agentRepository;

	@Autowired
	private RessourceRepository ressourceRepository;

	@Override
	public void deleteDemande(Long id) {
		// TODO Auto-generated method stub
		demandeRepository.delete(id);
	}

	@Override
	public Demande getDemande(Long id) {
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

	@Override
	public Demande createNewDemande(Long id_Requester, Long id_Approver,
			Long id_resource, Demande model)
	{
		Agent req = agentRepository.findOne(id_Requester);
		Agent approver = agentRepository.findOne(id_Approver);
		Ressource resource = ressourceRepository.findOne(id_resource);
		
		Assert.notNull(resource, "Ressource demandée ne peut pas être null");
		Assert.notNull(req, "Demandeur de partage de ressource ne peut pas être null");
		
		model.setRessource(resource);
		model.setRequester(req);
		model.setApprover(approver);
		
		return demandeRepository.save(model);
	}

}