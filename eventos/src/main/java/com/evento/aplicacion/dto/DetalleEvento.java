package com.evento.aplicacion.dto;

import java.time.LocalDate;

public class DetalleEvento {

	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private long totalBoletosDisponibles;
	private long boletosVendidos;
	private long boletosCanjeados;
	
	
	public DetalleEvento(String nombre, LocalDate fechaInicio, LocalDate fechaFin, long totalBoletosDisponibles,
			long boletosVendidos, long boletosCanjeados) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.totalBoletosDisponibles = totalBoletosDisponibles;
		this.boletosVendidos = boletosVendidos;
		this.boletosCanjeados = boletosCanjeados;
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


	public long getTotalBoletosDisponibles() {
		return totalBoletosDisponibles;
	}


	public void setTotalBoletosDisponibles(long totalBoletosDisponibles) {
		this.totalBoletosDisponibles = totalBoletosDisponibles;
	}


	public long getBoletosVendidos() {
		return boletosVendidos;
	}


	public void setBoletosVendidos(long boletosVendidos) {
		this.boletosVendidos = boletosVendidos;
	}


	public long getBoletosCanjeados() {
		return boletosCanjeados;
	}


	public void setBoletosCanjeados(long boletosCanjeados) {
		this.boletosCanjeados = boletosCanjeados;
	}
	
	
	
}
