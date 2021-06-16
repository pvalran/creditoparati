package com.pma.pimacpt.repository.cliente;

import com.pma.pimacpt.model.cliente.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosPersonalesRepo extends JpaRepository<DatosPersonales,Integer> {
}
