package com.pma.pimacpt.repository.colonia;

import com.pma.pimacpt.model.colonias.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepo extends JpaRepository<Estado,Integer> {
}
