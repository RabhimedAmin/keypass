package com.example.Service;

import java.util.List;

import com.example.model.Demande;

public interface DemandeService
{
	
	void deleteDemande(Long id);
	
	Demande getDemande(Long id);
	
	List<Demande> getAllDemandes();
	
	Demande modifydemande(Demande demande);
	
	Demande createdemande(Demande demande);
}
