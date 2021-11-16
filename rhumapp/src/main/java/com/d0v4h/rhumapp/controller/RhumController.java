package com.d0v4h.rhumapp.controller;

import java.util.Iterator;

import com.d0v4h.rhumapp.model.Rhum;
import com.d0v4h.rhumapp.service.RhumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.Data;

@Data
@Controller
public class RhumController {
	@Autowired
	private RhumService service;
	
	@GetMapping("/")
	public String home(Model model) {
		Iterable<Rhum> listRhums = service.getRhums();
		model.addAttribute("rhums", listRhums);
		return "home";
	}

	@GetMapping("/createRhum")
	public String createRhum(Model model) {
		Rhum r = new Rhum();
		model.addAttribute("rhum", r);
		return "formNewRhum";
	}

	@GetMapping("/updateRhum/{id}")
	public String updateRhum(@PathVariable("id") final int id, Model model) {
		Rhum e = service.getRhum(id);		
		model.addAttribute("rhum", e);	
		return "formUpdateRhum";		
	}

	@PostMapping("/saveRhum")
	public ModelAndView saveRhum(@ModelAttribute Rhum rhum) {
		if(rhum.getId() != null) {
			// Rhum from update form has the password field not filled,
			// so we fill it with the current password.
			// Rhum current = service.getRhum(rhum.getId());
			// rhum.setPassword(current.getPassword());
		}
		service.saveRhum(rhum);
		return new ModelAndView("redirect:/");	
	}

	@GetMapping("/deleteRhum/{id}")
	public ModelAndView deleteRhum(@PathVariable("id") final int id) {
		service.deleteRhum(id);
		return new ModelAndView("redirect:/");		
	}
}
