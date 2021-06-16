package com.pma.pimacpt.repository.tipo;

import com.pma.pimacpt.model.tipos.TipoDatoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDatosPersonalRepo extends JpaRepository<TipoDatoPersonal,Integer> {
}
