package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Service.PartageRessourceService;
import com.example.model.PartageRessource;
import com.example.repository.PartageRessourceRepository;

public class PartageRessourceServiceImpl implements PartageRessourceService
{
	

		@Autowired
		public void setpartageRessourceRepository(PartageRessourceRepository partageRessourceRepository) {
			this.partageRessourceRepository = partageRessourceRepository;
		}

		@Autowired
		PartageRessourceRepository partageRessourceRepository;

		@Override
		public void deletePartageRessource(Long id) {
			// TODO Auto-generated method stub
			partageRessourceRepository.delete(id);
		}

		@Override
		public PartageRessource getPartageRessource(Long id) {
			// TODO Auto-generated method stub
			return partageRessourceRepository.findOne(id);
		}

		@Override
		public List<PartageRessource> getAllPartageRessources() {
			// TODO Auto-generated method stub
			return partageRessourceRepository.findAll();
		}

		@Override
		public PartageRessource modifyPartageRessource(PartageRessource partageRessource) {
			// TODO Auto-generated method stub
			return partageRessourceRepository.save(partageRessource);
		}

		@Override
		public PartageRessource createPartageRessource(PartageRessource partageRessource) {
			// TODO Auto-generated method stub
			return partageRessourceRepository.save(partageRessource);
		}

	}

