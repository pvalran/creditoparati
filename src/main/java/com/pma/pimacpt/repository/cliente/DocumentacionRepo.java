package com.pma.pimacpt.repository.cliente;

import com.pma.pimacpt.model.cliente.Documentacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentacionRepo extends JpaRepository<Documentacion,Integer> {
}
