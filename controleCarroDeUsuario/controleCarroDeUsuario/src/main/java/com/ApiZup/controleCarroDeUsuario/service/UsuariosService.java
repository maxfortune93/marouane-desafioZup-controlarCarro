package com.ApiZup.controleCarroDeUsuario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiZup.controleCarroDeUsuario.model.Usuarios;
import com.ApiZup.controleCarroDeUsuario.repository.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository repository;
	
	public Optional<Usuarios> cadastrar(Usuarios usuario){
	Optional<Usuarios>emailExistente = repository.findByEmail(usuario.getEmail());
	Optional<Usuarios> cpfExistente = repository.findByCpf(usuario.getCpf());
	
	if(cpfExistente.isPresent() && emailExistente.isPresent()) {
		return Optional.empty();
	}else {
		return Optional.ofNullable(repository.save(usuario));
	}
			
	}
}
