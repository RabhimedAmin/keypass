package com.example.Service;

import java.util.List;

import com.example.model.Demande;

public interface DemandeService {

	void deleteDemande(long id);

	Demande getDemande(long id);

	List<Demande> getAllDemandes();

	Demande modifydemande(Demande demande);

	Demande createdemande(Demande demande);

}
