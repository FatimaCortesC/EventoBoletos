package com.evento.aplicacion.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos")
public class EventoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "fechaInicio", nullable = false)
	private LocalDate fechaInicio;
	
	@Column(name = "fechaFin", nullable = false)
	private LocalDate fechaFin;
	
	@Column(name = "boletosDisponibles", nullable = false)
	private Integer boletosDisponibles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getBoletosDisponibles() {
		return boletosDisponibles;
	}

	public void setBoletosDisponibles(Integer boletosDisponibles) {
		this.boletosDisponibles = boletosDisponibles;
	}

}
