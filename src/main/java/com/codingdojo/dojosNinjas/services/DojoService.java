package com.codingdojo.dojosNinjas.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosNinjas.models.Dojo;

import com.codingdojo.dojosNinjas.repository.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepo;
	
	
	// Method to find all the Dojos
	
	public List<Dojo> allDojo() {
		
		return dojoRepo.findAll();
		
	}
	
	// Method to create a Dojo
	
	public Dojo create(Dojo dojo ) {
		
		return dojoRepo.save(dojo);
		
	}
	
	public Dojo oneDojo(Long id) {
		
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		
		if(optionalDojo.isPresent()) {
			
			return optionalDojo.get();
			
		} 
		
		else {
			
			return null;
			
		}
		
	}

}
