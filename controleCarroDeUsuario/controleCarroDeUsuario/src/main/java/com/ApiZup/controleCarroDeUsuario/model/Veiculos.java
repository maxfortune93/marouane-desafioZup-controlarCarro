package com.ApiZup.controleCarroDeUsuario.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb-veiculos" )
public class Veiculos {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String modelo;
	
	@NotBlank
	private String 	ano;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());

	
	@ManyToOne
	@JsonIgnoreProperties("usuarioCarro")
	private Usuarios carroDono;
	
	
	private String diaDoRodizio;
	
	private boolean rodizioAtivo;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	
	
	
	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Usuarios getCarroDono() {
		return carroDono;
	}


	public void setCarroDono(Usuarios carroDono) {
		this.carroDono = carroDono;
	}


	public String getDiaDoRodizio() {
		return diaDoRodizio;
	}


	public void setDiaDoRodizio(String diaDoRodizio) {
		this.diaDoRodizio = diaDoRodizio;
	}


	public boolean isRodizioAtivo() {
		return rodizioAtivo;
	}


	public void setRodizioAtivo(boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
	
	
	
	
}
