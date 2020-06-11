package com.gcmmogi.gcm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcmmogi.gcm.entities.VeiculoAveriguado;
import com.gcmmogi.gcm.services.VeiculoAveriguadoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoAveriguadoResource {
	
	@Autowired
	private VeiculoAveriguadoService service;
	
	@GetMapping
	public ResponseEntity<List<VeiculoAveriguado>> findAll(){
		List<VeiculoAveriguado> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VeiculoAveriguado> findById(@PathVariable Long id){
		VeiculoAveriguado obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
