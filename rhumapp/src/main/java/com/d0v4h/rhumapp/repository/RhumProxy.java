package com.d0v4h.rhumapp.repository;

import java.util.Iterator;

import javax.lang.model.type.NullType;

import com.d0v4h.rhumapp.CustomProperties;
import com.d0v4h.rhumapp.model.Rhum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RhumProxy {
	@Autowired
	// private CustomProperties properties;
	
	public Iterable<Rhum> getRhums() {
		// String baseApiUrl = properties.getApiurl();
		String baseApiUrl = "http://localhost:9000";
		String getRhumsUrl = baseApiUrl + "/rhums";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Rhum>> response = restTemplate.exchange(
			getRhumsUrl,
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<Iterable<Rhum>>() {}
		);

		// log.debug("Get Rhums call " + response.getStatusCode().toString());
		// System.out.println(response.toString());
		System.out.println(response.getBody().toString());
		return response.getBody();
	}
	
	public Rhum getRhum(int id) {
		// String baseApiUrl = properties.getApiurl();
		String baseApiUrl = "http://localhost:9000";
		String getRhumUrl = baseApiUrl + "/rhum/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Rhum> response = restTemplate.exchange(
			getRhumUrl,
			HttpMethod.GET,
			null,
			Rhum.class
		);

		// log.debug("Get Rhum call " + response.getStatusCode().toString());

		return response.getBody();
	}

	/**
	 * Add a new rhum 
	 * @param e A new rhum (without an id)
	 * @return The rhum full filled (with an id)
	 */
	public Rhum createRhum(Rhum e) {
		// String baseApiUrl = properties.getApiurl();
		String baseApiUrl = "http://localhost:9000";
		String createRhumUrl = baseApiUrl + "/rhum";
	
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Rhum> request = new HttpEntity<Rhum>(e);
		ResponseEntity<Rhum> response = restTemplate.exchange(
			createRhumUrl,
			HttpMethod.POST,
			request,
			Rhum.class);
	
		// log.debug("Create Rhum call " + response.getStatusCode().toString());
	
		return response.getBody();
	}

	/**
	 * Update a rhum - using the PUT HTTP Method.
	 * @param e Existing rhum to update
	 */
	public Rhum updateRhum(Rhum e) {
		// String baseApiUrl = properties.getApiurl();
		String baseApiUrl = "http://localhost:9000";
		String updateRhumUrl = baseApiUrl + "/rhum/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Rhum> request = new HttpEntity<Rhum>(e);

		System.out.println(request.toString());

		ResponseEntity<Rhum> response = restTemplate.exchange(
				updateRhumUrl, 
				HttpMethod.PUT, 
				request, 
				Rhum.class);
		
		// log.debug("Update Rhum call " + response.getStatusCode().toString());
		
		return response.getBody();
	}

	/**
	 * Delete an rhum using exchange method of RestTemplate
	 * instead of delete method in order to log the response status code.
	 * @param e The rhum to delete
	 */
	public void deleteRhum(int id) {
		// String baseApiUrl = properties.getApiurl();
		String baseApiUrl = "http://localhost:9000";
		String deleteRhumUrl = baseApiUrl + "/rhum/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteRhumUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
	}
}
