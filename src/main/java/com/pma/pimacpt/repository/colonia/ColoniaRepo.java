package com.pma.pimacpt.repository.colonia;

import com.pma.pimacpt.model.colonias.Colonia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.Optional;

@Repository
public interface ColoniaRepo extends JpaRepository<Colonia,Integer> {
    boolean existsColoniaByCodigoPostal(String cp);
    Optional<Colonia> findByCodigoPostal(String cp);
}
