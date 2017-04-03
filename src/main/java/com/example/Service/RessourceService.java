package com.example.Service;

import java.util.List;

import com.example.model.Ressource;

public interface RessourceService {
	public Ressource createRessource(Ressource ressource);

	public List<Ressource> getAllRessources();

	public Ressource modifyRessource(Ressource ressource);

	Ressource getRessource(long id);

	void deleteRessource(long id);
}
