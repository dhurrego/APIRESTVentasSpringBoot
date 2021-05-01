package com.deividurrego.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
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

import com.deividurrego.exception.ModeloNotFoundException;
import com.deividurrego.model.Persona;
import com.deividurrego.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> lista = service.listar();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public EntityModel<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Persona persona = service.listarPorId(id);
		if (persona == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: ".concat(id.toString()));
		}
		EntityModel<Persona> recurso = EntityModel.of(persona);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).listarPorId(id));
		recurso.add(link.withRel("persona-recurso"));
		return recurso;
	}
	
	@PostMapping
	public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona persona){
		Persona per = service.registrar(persona);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(per.getIdPersona()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona){
		Persona per = service.modificar(persona);
		return new ResponseEntity<Persona>(per, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
