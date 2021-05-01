package com.deividurrego.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deividurrego.model.Persona;
import com.deividurrego.repo.IGenericRepo;
import com.deividurrego.service.IPersonaService;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

	@Autowired
	private IGenericRepo<Persona, Integer> repo;
	
	@Override
	protected IGenericRepo<Persona, Integer> getRepo() {
		return repo;
	}

}
