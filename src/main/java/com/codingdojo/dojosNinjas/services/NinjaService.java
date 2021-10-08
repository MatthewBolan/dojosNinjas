package com.codingdojo.dojosNinjas.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosNinjas.models.Ninja;

import com.codingdojo.dojosNinjas.repository.NinjaRepository;


@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	
	
	
	public List<Ninja> allNinjas() {
		
		return ninjaRepo.findAll();
		
	}

	
	
	public Ninja create(Ninja Ninj) {
		
		return ninjaRepo.save(Ninj);
		
	}
	
	
	
	public Ninja oneNinja(Long id) {
		
		Optional<Ninja> optionalNinj = ninjaRepo.findById(id);
		
		if (optionalNinj.isPresent()) {
			
			return optionalNinj.get();
			
		} 
		
		else {
			
			return null;
			
		}
	}
	
	
	
	public Ninja updateNinj(Ninja Ninj) {
		
		return ninjaRepo.save(Ninj);
		
	}
	
	
	
	
	public void destroy(Long id) {
		
		ninjaRepo.deleteById(id);
	}
	
}