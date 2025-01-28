package com.evento.aplicacion.models;

import jakarta.persistence.*;

@Entity
@Table(name = "boletos")
public class BoletoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idBoleto;

	@ManyToOne
	@JoinColumn(name = "evento_id", nullable = false)
	private EventoModel evento;

	@Column(name = "Estado", nullable = false)
	private String estado;

	@Column(name = "Codigo", nullable = false)
	private String codigo;
	
    @Column(name = "Canjeado", nullable = false)
    private boolean canjeado;

	public Long getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(Long idBoleto) {
		this.idBoleto = idBoleto;
	}

	public EventoModel getEvento() {
		return evento;
	}

	public void setEvento(EventoModel evento) {
		this.evento = evento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isCanjeado() {
		return canjeado;
	}

	public void setCanjeado(boolean canjeado) {
		this.canjeado = canjeado;
	}
	
	

}
