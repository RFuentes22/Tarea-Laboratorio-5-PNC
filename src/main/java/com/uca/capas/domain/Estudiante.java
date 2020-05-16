package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {

	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoEstudiante;
	
	@Column(name="nombre")
	@Size(min = 1,max = 50, message = "El Nombre del estudiante debe tener de 1 a 50 caracteres")
	private String	Nombre;
	
	@Column(name="apellido")
	@Size(min = 1,max = 50, message = "El Apellido del estudiante debe tener de 1 a 50 caracteres")
	private String	Apellido;
	
	@Column(name="carne")
	@Size(min = 1,max = 10, message = "El Carne del estudiante debe tener de 1 a 10 caracteres")
	private String Carne;
	@Column(name="carrera")
	@Size(min = 1,max = 100, message = "La Carrera del estudiante debe tener de 1 a 100 caracteres")
	private String Carrera;
	
	
	
	
	public Estudiante(Integer codigoEstudiante,
			@Size(min = 1, max = 50, message = "El Nombre del estudiante debe tener de 1 a 50 caracteres") String nombre,
			@Size(min = 1, max = 50, message = "El Apellido del estudiante debe tener de 1 a 50 caracteres") String apellido,
			@Size(min = 1, max = 10, message = "El Carne del estudiante debe tener de 1 a 10 caracteres") String carne,
			@Size(min = 1, max = 100, message = "La Carrera del estudiante debe tener de 1 a 100 caracteres") String carrera) {
		super();
		this.codigoEstudiante = codigoEstudiante;
		Nombre = nombre;
		Apellido = apellido;
		Carne = carne;
		Carrera = carrera;
	}
	public Estudiante(){
		
	}
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getCarne() {
		return Carne;
	}
	public void setCarne(String carne) {
		Carne = carne;
	}
	public String getCarrera() {
		return Carrera;
	}
	public void setCarrera(String carrera) {
		Carrera = carrera;
	}
	
	
	

}
