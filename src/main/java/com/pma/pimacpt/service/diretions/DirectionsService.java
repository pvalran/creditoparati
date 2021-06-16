package com.pma.pimacpt.service.diretions;

import com.pma.pimacpt.model.colonias.Colonia;
import com.pma.pimacpt.repository.colonia.ColoniaRepo;
import com.pma.pimacpt.repository.colonia.EstadoRepo;
import com.pma.pimacpt.repository.colonia.MunicipioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DirectionsService {

    @Autowired
    private ColoniaRepo coloniaRepo;
    @Autowired
    private EstadoRepo estadoRepo;
    @Autowired
    private MunicipioRepo municipioRepo;

    public List<Colonia> getColoniaByCp (String cp) throws NoSuchElementException {
        List<Colonia> colonias=new ArrayList<>();
        if(coloniaRepo.existsColoniaByCodigoPostal(cp)){
            coloniaRepo.findByCodigoPostal(cp).ifPresent(colonias::add);
            return colonias;
        }
        throw new NoSuchElementException("Colonia does't exist by cp "+cp);
    }
}
