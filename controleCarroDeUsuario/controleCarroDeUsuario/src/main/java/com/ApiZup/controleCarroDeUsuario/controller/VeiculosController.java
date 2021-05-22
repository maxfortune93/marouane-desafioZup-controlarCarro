/*package com.ApiZup.controleCarroDeUsuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiZup.controleCarroDeUsuario.model.Veiculos;
import com.ApiZup.controleCarroDeUsuario.repository.VeiculosRepository;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("*")
public class VeiculosController {

	@Autowired
	private VeiculosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Veiculos>>GetAll(){
		return ResponseEntity.ok(repository.findAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculos> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//@GetMapping("")
	
}
*/