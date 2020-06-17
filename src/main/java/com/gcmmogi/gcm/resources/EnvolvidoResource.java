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

import com.gcmmogi.gcm.dto.EnvolvidoNovoDTO;
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

	@PostMapping
	public ResponseEntity<Envolvido> insert(@RequestBody EnvolvidoNovoDTO objDto) {
		Envolvido obj = service.fromDTO(objDto);
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
	public ResponseEntity<Envolvido> update(@PathVariable Long id, @RequestBody EnvolvidoNovoDTO objDto) {
		Envolvido obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
