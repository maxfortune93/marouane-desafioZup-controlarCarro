package com.ApiZup.controleCarroDeUsuario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiZup.controleCarroDeUsuario.model.Usuarios;
import com.ApiZup.controleCarroDeUsuario.repository.UsuariosRepository;
import com.ApiZup.controleCarroDeUsuario.service.UsuariosService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {
	
	@Autowired 
	private UsuariosRepository repository;
	
	@Autowired
	private UsuariosService service;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuarios> cadastrarUsuario(@RequestBody Usuarios usuario){
		
	Optional<Usuarios> existente = service.cadastrar(usuario);
	
	if(existente.isEmpty()) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();//return 400
	}else{
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);// return 201
	}
	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
	repository.deleteById(id);
	}
}
