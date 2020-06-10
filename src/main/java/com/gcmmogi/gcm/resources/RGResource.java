package com.gcmmogi.gcm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcmmogi.gcm.entities.RG;
import com.gcmmogi.gcm.services.RGService;

@RestController
@RequestMapping(value = "/rgs")
public class RGResource {
	
	@Autowired
	private RGService service;
	
	@GetMapping
	public ResponseEntity<List<RG>> findAll(){
		List<RG> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RG> findById(@PathVariable Long id){
		RG obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
