package com.d0v4h.rhumapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d0v4h.rhumapi.model.Rhum;
import com.d0v4h.rhumapi.repository.RhumRepository;

import lombok.Data;

@Data
@Service
public class RhumService {
	
	@Autowired
	private RhumRepository rhumRepository;
	
	public Optional<Rhum> getRhum(final Integer id){
		return rhumRepository.findById(id);
	}
	
	public Iterable<Rhum> getRhums(){
		return rhumRepository.findAll();
	}
	
	public void deleteRhum(final Integer id) {
		rhumRepository.deleteById(id);
	}
	
	public Rhum saveRhum(Rhum rhum) {
		Rhum savedRhum = rhumRepository.save(rhum);
		return savedRhum;
	}
	
}
