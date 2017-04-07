
	package com.example.Service;

import java.util.List;

import com.example.model.PartageRessource;

public interface PartageRessourceService
{

	void deletePartageRessource(Long id);

	PartageRessource getPartageRessource(Long id);

	List<PartageRessource> getAllPartageRessources();

	PartageRessource modifyPartageRessource(PartageRessource partageRessource);

	PartageRessource createPartageRessource(PartageRessource partageRessource);
	
}

