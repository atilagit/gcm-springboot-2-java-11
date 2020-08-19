package com.gcmmogi.gcm.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gcmmogi.gcm.dto.MeusBoletinsDTO;
import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.services.BoletimOcorrenciaService;

@RestController
@RequestMapping(value = "/boletins")
public class BoletimOcorrenciaResource {
	
	@Autowired
	private BoletimOcorrenciaService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<BoletimOcorrencia>> findAll(){
		List<BoletimOcorrencia> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/meus-boletins")
	public ResponseEntity<List<MeusBoletinsDTO>> meusBoletins(){
		List<MeusBoletinsDTO> list = service.meusBoletins();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BoletimOcorrencia> findById(@PathVariable Long id){
		BoletimOcorrencia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<BoletimOcorrencia> insert(@RequestBody BoletimOcorrencia obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<BoletimOcorrencia> update(@PathVariable Long id, @RequestBody BoletimOcorrencia obj){
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
