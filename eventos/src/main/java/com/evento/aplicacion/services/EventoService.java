package com.evento.aplicacion.services;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evento.aplicacion.dto.DetalleEvento;
import com.evento.aplicacion.models.BoletoModel;
import com.evento.aplicacion.models.EventoModel;
import com.evento.aplicacion.repositories.IBoletoRepository;
import com.evento.aplicacion.repositories.IEventoRepository;

@Service
public class EventoService {

	@Autowired
	IEventoRepository eventoRepository;

	@Autowired
	IBoletoRepository boletoRepository;

	LocalDate fechaActual = LocalDate.now();

	public EventoModel crearEvento(EventoModel evento) {
		if (evento.getFechaInicio().isBefore(fechaActual)) {
			throw new IllegalArgumentException("La fecha de inicio del evento no puede ser menor a la actual");
		}

		if (evento.getFechaFin().isBefore(evento.getFechaInicio())) {
			throw new IllegalArgumentException(
					"La fecha de fin del evento no puede ser menor a la de inicio del evento");
		}
		if (evento.getBoletosDisponibles() < 1 || evento.getBoletosDisponibles() > 300) {
			throw new IllegalArgumentException("El número total de boletos disponibles debe estar entre 1 y 300.");
		}
		return eventoRepository.save(evento);
	}

	public String actualizarEvento(Long Id, EventoModel eventoAct) {
		Optional<EventoModel> optionalEvento = eventoRepository.findById(Id);

		if (optionalEvento.isPresent()) {

			EventoModel eventoExistente = optionalEvento.get();

			//Validación sobre que la fecha de inicio no sea menor a la actual
			if (eventoAct.getFechaInicio().isBefore(fechaActual)) {
				throw new IllegalArgumentException("La fecha de inicio del evento no puede ser menor a la actual");
			}
			//validacion sobre la fecha de fin, pues no debe ser menor a la fecha de inicio
			if (eventoAct.getFechaFin().isBefore(eventoAct.getFechaInicio())) {
				throw new IllegalArgumentException(
						"La fecha de fin del evento no puede ser menor a la de inicio del evento");
			}

			//Obtiene los boletos vendidos
			int boletosVendidos = eventoExistente.getBoletosDisponibles() - eventoExistente.getBoletosDisponibles();
			
			//Validación de boletos disponibles
			if (eventoAct.getBoletosDisponibles() < boletosVendidos) {
				return "No es posible disminuir el total de boletos pues el número de boletos vendidos es mayor al número de "
						+ "boletos que se trata de actualizar";
			}
			
			//Se actualizan los valores del evento
			eventoExistente.setNombre(eventoAct.getNombre());
			eventoExistente.setFechaInicio(eventoAct.getFechaInicio());
			eventoExistente.setFechaFin(eventoAct.getFechaFin());
			eventoExistente.setBoletosDisponibles(eventoAct.getBoletosDisponibles());

			//Se guarada el evento actualizado
			eventoRepository.save(eventoExistente);
			return "El evento se ha actualizado";
		} else
			return "No se encontró el respectivo evento";

	}

	public String venderBoleto(Long eventoId) {
		Optional<EventoModel> optionalEvento = eventoRepository.findById(eventoId);
		if (optionalEvento.isPresent()) {
			EventoModel evento = optionalEvento.get();

			if (evento.getBoletosDisponibles() <= 0) {
				throw new IllegalStateException("No se encontraron boletos de este evento");
			}

			evento.setBoletosDisponibles(evento.getBoletosDisponibles() - 1);
			eventoRepository.save(evento);

			BoletoModel boleto = new BoletoModel();
			boleto.setEvento(evento);
			boleto.setEstado("Vendido");
			boleto.setCodigo(UUID.randomUUID().toString());
			boletoRepository.save(boleto);
			return "El boleto con código" + boleto.getCodigo() + " se ha vendido";
		} else {
			throw new IllegalArgumentException("No existe el respectivo evento");
		}

	}

	public String canjearBoleto(String codigoBoleto) {
		Optional<BoletoModel> optionalBoleto = boletoRepository.findByCodigo(codigoBoleto);

		if (optionalBoleto.isPresent()) {
			BoletoModel boleto = optionalBoleto.get();
			EventoModel evento = boleto.getEvento();

			if (boleto.getEstado().equals("Canjeado")) {
				throw new IllegalStateException("El boleto se ha canjeado");
			}

			if (fechaActual.isBefore(evento.getFechaInicio()) || fechaActual.isAfter(evento.getFechaFin())) {
				throw new IllegalStateException("Solo se puede canjear durante la fecha del evento");

			}

			boleto.setEstado("Canjeado");
			boletoRepository.save(boleto);
			return "El boleto se canjeo exitosamente";
		} else {
			throw new IllegalArgumentException("No existe el boleto");
		}
	}

	public String eliminarEvento(Long idEvento) {
		EventoModel evento = eventoRepository.findById(idEvento)
				.orElseThrow(() -> new IllegalArgumentException("El evento no existe"));

		if (evento.getFechaFin().isBefore(LocalDate.now())) {
			eventoRepository.delete(evento);
			return "Ha sido eliminado el evento expirado";
		}
		long boletosVendidos = boletoRepository.countByEventoIdAndCanjeadoTrue(idEvento);
		if (boletosVendidos == 0) {
			eventoRepository.delete(evento);
			return "Evento eliminado sin ningún boleto vendido";
		}
		throw new IllegalArgumentException(
				"No es posible eliminar el evento debido a que aun esta " + "vigente o cuenta con boletos en venta");
	}

	public DetalleEvento obtenerDetalleEventos(Long eventoId) {
		EventoModel evento = eventoRepository.findById(eventoId)
				.orElseThrow(() -> new RuntimeException("No se ha encontrado el evento"));
		long boletosVendidos = boletoRepository.countByEventoId(eventoId);
		long boletosCanjeados = boletoRepository.countByEventoIdAndCanjeadoTrue(eventoId);

		return new DetalleEvento(evento.getNombre(), evento.getFechaInicio(), evento.getFechaFin(),
				evento.getBoletosDisponibles(), boletosVendidos, boletosCanjeados);
	}

}