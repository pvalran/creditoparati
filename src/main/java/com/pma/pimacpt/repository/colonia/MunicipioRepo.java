package com.pma.pimacpt.repository.colonia;

import com.pma.pimacpt.model.colonias.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepo extends JpaRepository<Municipio,Integer> {
}
