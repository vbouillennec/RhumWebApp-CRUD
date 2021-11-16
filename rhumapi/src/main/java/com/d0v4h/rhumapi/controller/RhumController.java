package com.d0v4h.rhumapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.d0v4h.rhumapi.model.Rhum;
import com.d0v4h.rhumapi.repository.RhumRepository;
import com.d0v4h.rhumapi.service.RhumService;

@Controller
public class RhumController {
	
	@Autowired
	private RhumService rhumService;
	// private RhumRepository rhumRepository;
	
	/**
    * Read - Get one rhum
    * @param id The id of the rhum
    * @return - A Rhum object of Rhum full filled
    */
	@GetMapping("/rhum/{id}")
	public @ResponseBody Rhum getRhum(@PathVariable("id") final Integer id) {
		Optional<Rhum> rhum = rhumService.getRhum(id);
		if(rhum.isPresent())
			return rhum.get();
		else
			return null;
	}
	
	/**
    * Read - Get all rhums
    * @return - An Iterable object of Rhum full filled
    */
	@GetMapping("/rhums")
	public @ResponseBody Iterable<Rhum> getRhums() {
		return rhumService.getRhums();
	}
	
	/**
    * Create - Add a new rhum
    * @param Rhum The Rhum object to create
    * @return - A Rhum object of Rhum full filled
    */
	@PostMapping("/rhum")
	public @ResponseBody Rhum createRhum(@RequestBody Rhum rhum) {
		return rhumService.saveRhum(rhum);
	}
	
	/**
    * Update - Add a new rhum
    * @param id The id of the rhum to update
    * @param rhum The Rhum object to update
    * @return
    */
	@PutMapping("/rhum/{id}")
	public @ResponseBody Rhum updateRhum(@PathVariable("id") final Integer id, @RequestBody Rhum rhum) {
		Optional<Rhum> r = rhumService.getRhum(id);
		if(r.isPresent()) {
			Rhum currentRhum = r.get();
			
			String rhumName = rhum.getRhumName();
			if(rhumName != null) {
				currentRhum.setRhumName(rhumName);
			}
			String alcDeg = rhum.getAlcDeg();
			if(alcDeg != null) {
				currentRhum.setAlcDeg(alcDeg);
			}
			String origin = rhum.getOrigin();
			if(origin != null) {
				currentRhum.setOrigin(origin);
			}
			rhumService.saveRhum(currentRhum);
			return currentRhum;
		} else {
			return null;
		}
	}
	
	/**
    * Delete - Remove a rhum
    * @param id The id of the rhum to delete
    */
	@DeleteMapping("/rhum/{id}")
	public @ResponseBody Rhum deleteRhum(@PathVariable("id") final Integer id) {
		rhumService.deleteRhum(id);
		Optional<Rhum> r = rhumService.getRhum(id);
		if(r.isPresent()) {
			return r.get();
		} else {
			return null;
		}
	}
}
