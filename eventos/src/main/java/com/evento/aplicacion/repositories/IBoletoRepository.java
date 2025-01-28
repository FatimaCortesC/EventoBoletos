package com.evento.aplicacion.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evento.aplicacion.models.BoletoModel;
import java.util.List;


@Repository
public interface IBoletoRepository extends JpaRepository<BoletoModel, Long> {
	Optional<BoletoModel> findByCodigo(String codigo);
	long countByEventoIdAndCanjeadoTrue(long eventoId);
	long countByEventoId(long eventoId);
}
