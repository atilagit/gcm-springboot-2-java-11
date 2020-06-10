package com.gcmmogi.gcm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcmmogi.gcm.entities.Envolvido;
import com.gcmmogi.gcm.services.EnvolvidoService;

@RestController
@RequestMapping(value = "/envolvidos")
public class EnvolvidoResource {
	
	@Autowired
	private EnvolvidoService service;
	
	@GetMapping
	public ResponseEntity<List<Envolvido>> findAll(){
		List<Envolvido> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Envolvido> findById(@PathVariable Long id){
		Envolvido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
