package com.agenda.contactos.modelo.Entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity(name = "usuarios")
public class Contacto implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//TODO: Settear el tamaño de salto a 1
	private Integer id;

	@NotBlank(message = "Debe ingresar su nombre")
	@Column(name = "nombre")
	private String nombre;


	@NotBlank(message = "Debe ingresar su celular")
	@Column(name = "celular")
	private String celular;

	public Contacto(@NotBlank(message = "Debe ingresar su nombre") String nombre,
			@NotBlank(message = "Debe ingresar su celular") String celular) {
		this.nombre = nombre;
		this.celular = celular;
	}

	public Contacto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}


}
