package com.gcmmogi.gcm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.services.BoletimOcorrenciaService;

@RestController
@RequestMapping(value = "/boletins")
public class BoletimOcorrenciaResource {
	
	@Autowired
	private BoletimOcorrenciaService service;
	
	@GetMapping
	public ResponseEntity<List<BoletimOcorrencia>> findAll(){
		List<BoletimOcorrencia> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BoletimOcorrencia> findById(@PathVariable Long id){
		BoletimOcorrencia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
