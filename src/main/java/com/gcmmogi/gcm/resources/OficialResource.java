package com.gcmmogi.gcm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.services.OficialService;

@RestController
@RequestMapping(value = "/oficiais")
public class OficialResource {
	
	@Autowired
	private OficialService service;
	
	@GetMapping
	public ResponseEntity<List<Oficial>> findAll(){
		List<Oficial> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Oficial> findById(@PathVariable Long id){
		Oficial obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
