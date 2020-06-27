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

import com.gcmmogi.gcm.dto.BairroDTO;
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
	
	@GetMapping(path = "/top5-com-mais-boletins")
	public ResponseEntity<List<BairroDTO>> topBairroComMaisBO(){
		List<BairroDTO> list = service.topBairrosComMaisBO();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Bairro> insert(@RequestBody Bairro obj) {
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
	public ResponseEntity<Bairro> update(@PathVariable Long id, @RequestBody Bairro obj){
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
