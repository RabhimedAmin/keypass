package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.GroupeService;
import com.example.model.Account;
import com.example.model.Agent;
import com.example.model.Groupe;
import com.example.repository.AgentRepository;
import com.example.repository.GroupeRepository;

@Service
public class GroupeServiceImpl implements GroupeService {
	@Autowired
	private GroupeRepository groupeRepository;
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public Groupe createGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		return groupeRepository.save(groupe);
	}

	@Override
	public Groupe modifyGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		return groupeRepository.save(groupe);
	}

	@Override
	public boolean affecterAgentToGroupe(Groupe groupe, Agent agent) {
		if(groupe.getAgentList().contains(agent)){
				return true;}
		return false;
	}

	@Override
	public Groupe getGroupe(long id) {
		// TODO Auto-generated method stub
		return groupeRepository.findOne(id);
	}

	@Override
	public List<Groupe> getAllGroupes() {
		// TODO Auto-generated method stub
		return groupeRepository.findAll();
	}

	@Override
	public void deleteGroupe(long id) {
		// TODO Auto-generated method stub
		agentRepository.delete(id);
	}
}
