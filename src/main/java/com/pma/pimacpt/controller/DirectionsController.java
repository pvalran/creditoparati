package com.pma.pimacpt.controller;

import com.pma.pimacpt.dto.Respuesta;
import com.pma.pimacpt.model.colonias.Colonia;
import com.pma.pimacpt.service.diretions.DirectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/directions")
public class DirectionsController {
    @Autowired
    private DirectionsService directionsService;

    @GetMapping(path = "/getByCP/{cp}")
    public ResponseEntity<Respuesta> getByCP (@PathVariable("cp") String codigoPostal) {
        List<Colonia> colonia=null;
        try {
            colonia=directionsService.getColoniaByCp(codigoPostal);
            return  new ResponseEntity(
                    new Respuesta(
                            "Success",
                            true,
                            colonia
                    ),
                    HttpStatus.OK
            );
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(
                    new Respuesta(
                            "No existe colonia",
                            false,
                            e.getMessage()
                    ),
                    HttpStatus.FORBIDDEN
            );
        }
    }
}
