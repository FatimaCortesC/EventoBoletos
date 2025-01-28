package com.evento.aplicacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evento.aplicacion.dto.DetalleEvento;
import com.evento.aplicacion.models.EventoModel;
import com.evento.aplicacion.services.EventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/evento")

public class EventoController {

	@Autowired
	EventoService eventoService;

	@PostMapping()
	public EventoModel guardarEvento(@RequestBody EventoModel evento) {
		return this.eventoService.crearEvento(evento);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<String> actualizarEvento(@PathVariable Long Id, @RequestBody EventoModel evento) {
		String actualizacion = eventoService.actualizarEvento(Id, evento);
		if (actualizacion.equals("El evento se ha actualizado")) {
			return ResponseEntity.ok(actualizacion);
		} else {
			return ResponseEntity.badRequest().body(actualizacion);
		}
	}

	@PostMapping("/{Id}/vender-boleto")
	public ResponseEntity<String> venderBoleto(@PathVariable Long Id) {
		try {
			String mensaje = eventoService.venderBoleto(Id);
			return ResponseEntity.ok(mensaje);
		} catch (IllegalArgumentException | IllegalStateException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/canjear-boleto/{codigo}")
	public ResponseEntity<String> canjearBoleto(@PathVariable String codigo) {
		try {
			String mensaje = eventoService.canjearBoleto(codigo);
			return ResponseEntity.ok(mensaje);
		} catch (IllegalArgumentException | IllegalStateException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarEvento(@PathVariable("id") Long id) {
		try {
			String mensaje = eventoService.eliminarEvento(id);
			return ResponseEntity.ok(mensaje);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<DetalleEvento> obtenerDetalleEvento(@PathVariable("id") Long id){
		DetalleEvento detalle = eventoService.obtenerDetalleEventos(id);
		return ResponseEntity.ok(detalle);
	}

}
