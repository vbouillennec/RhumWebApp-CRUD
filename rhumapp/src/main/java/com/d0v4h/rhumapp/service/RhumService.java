package com.d0v4h.rhumapp.service;

import com.d0v4h.rhumapp.model.Rhum;
import com.d0v4h.rhumapp.repository.RhumProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class RhumService {
	@Autowired
	private RhumProxy rhumProxy;

	public Rhum getRhum(final int id) {
		return rhumProxy.getRhum(id);
	}

	public Iterable<Rhum> getRhums() {
		return rhumProxy.getRhums();
	}

	public void deleteRhum(final int id) {
		rhumProxy.deleteRhum(id);
	}
	
	public Rhum saveRhum(Rhum rhum) {
		Rhum savedRhum;
		
		// Functional rule : Last name must be capitalized.
		// rhum.setLastName(rhum.getLastName().toUpperCase());

		if(rhum.getId() == null) {
			// If id is null, then it is a new rhum.
			savedRhum = rhumProxy.createRhum(rhum);
		} else {
			savedRhum = rhumProxy.updateRhum(rhum);
		}
		
		return savedRhum;
	}
}
