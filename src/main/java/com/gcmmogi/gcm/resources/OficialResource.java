package com.gcmmogi.gcm.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.entities.enums.Posto;

@RestController
@RequestMapping(value = "/oficiais")
public class OficialResource {
	
	@GetMapping
	public ResponseEntity<Oficial> findAll(){
		Oficial o = new Oficial(1L, "joao87", "123", "Joao", "Time-A", 5, Posto.EM_CAMPO);
		return ResponseEntity.ok().body(o);
	}
}
