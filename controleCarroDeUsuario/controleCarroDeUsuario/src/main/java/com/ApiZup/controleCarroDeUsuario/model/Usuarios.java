package com.ApiZup.controleCarroDeUsuario.model;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb-usuarios",uniqueConstraints = @UniqueConstraint(columnNames= {"email","cpf"}))
public class Usuarios {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank (message = "Nome é obrigatório")
	private String nome;
	
	@Email 
	@NotBlank
	@Column(unique=true)

	private String email;
	
	@CPF (message = "CPF inválido") 
	@NotBlank
	@Column(unique=true)

	private String cpf;
	
	@NotNull
	private LocalDate dataNascimento;
	
	
	
	/*@NotBlank
	@Size(min = 6)
	private String senha;*/
	
	/*@OneToMany(mappedBy = "carroDono", cascade =CascadeType.REMOVE)
	@JsonIgnoreProperties("carroDono")
	private List<Veiculos> usuarioCarro;*/
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/*public List<Veiculos> getUsuarioCarro() {
		return usuarioCarro;
	}

	public void setUsuarioCarro(List<Veiculos> usuarioCarro) {
		this.usuarioCarro = usuarioCarro;
	}*/

	
	

}
