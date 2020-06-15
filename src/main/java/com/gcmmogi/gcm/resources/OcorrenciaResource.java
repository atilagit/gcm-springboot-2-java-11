package com.gcmmogi.gcm.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.services.OcorrenciaService;

@RestController
@RequestMapping(value = "/ocorrencias")
public class OcorrenciaResource {
	
	@Autowired
	private OcorrenciaService service;
	
	@GetMapping
	public ResponseEntity<List<Ocorrencia>> findAll(){
		List<Ocorrencia> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ocorrencia> findById(@PathVariable Long id){
		Ocorrencia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Ocorrencia> insert(@RequestBody Ocorrencia obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Ocorrencia> update(@PathVariable Long id, @RequestBody Ocorrencia obj){
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
