package com.gcmmogi.gcm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcmmogi.gcm.entities.Bairro;
import com.gcmmogi.gcm.services.BairroService;

@RestController
@RequestMapping(value = "/bairros")
public class BairroResource {
	
	@Autowired
	private BairroService service;
	
	@GetMapping
	public ResponseEntity<List<Bairro>> findAll(){
		List<Bairro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bairro> findById(@PathVariable Long id){
		Bairro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
