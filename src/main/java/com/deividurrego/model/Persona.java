package com.deividurrego.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;

	@NotEmpty(message = "{persona.nombres.notEmpty}")
	@Size(min = 3, max = 70, message = "{persona.nombres.size}")
	@Pattern(regexp = "[a-zA-Z ]+", message = "{persona.nombres.pattern}")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@NotEmpty(message = "{persona.apellidos.notEmpty}")
	@Size(min = 3, max = 70, message = "{persona.apellidos.size}")
	@Pattern(regexp = "[a-zA-Z ]+", message = "{persona.apellidos.pattern}")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
