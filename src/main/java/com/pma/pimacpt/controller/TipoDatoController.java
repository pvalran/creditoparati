package com.pma.pimacpt.controller;

import com.pma.pimacpt.dto.Respuesta;
import com.pma.pimacpt.model.tipos.TipoDatoPersonal;
import com.pma.pimacpt.service.cliente.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tipo")
public class TipoDatoController {

    @Autowired
    private TipoService service;

    @GetMapping("/datosCatalogo")
    public ResponseEntity<Respuesta> tipoDatos(){
        return new ResponseEntity(
                new Respuesta(
                        "Lista tipo dato personal",
                        true,
                        service.getALLTipoDatoPersonal()
                ),
                HttpStatus.OK
        );
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addDatosCatalogo")
    public ResponseEntity<Respuesta> addDatosCatalogo(@RequestBody @Valid TipoDatoPersonal datoPersonal, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Respuesta(
                    "Error agregando catalogo: " + bindingResult.getNestedPath() + " ",
                    false,
                    bindingResult.getFieldError()
            ), HttpStatus.BAD_REQUEST);
        }
        else {
            if(service.saveTipoDatosPersonal(datoPersonal)){
                return new ResponseEntity(new Respuesta(
                        "Guardado",
                        true,
                        null
                ), HttpStatus.OK);
            }
            else {
                return new ResponseEntity(new Respuesta(
                        "Algo salio mal",
                        false,
                        null
                ), HttpStatus.OK);
            }
        }
    }

    @GetMapping("/tipo-documento/catalogo")
    public ResponseEntity<Respuesta> getCatalogoTipoDocumento(){
        return new ResponseEntity(new Respuesta(
                "Catalogo tipo documento",
                true,
                service.getAllTipoDocumento()
        ),HttpStatus.OK);
    }

    @GetMapping("/genero/catalog")
    public ResponseEntity<Respuesta> getGenero(){
        return new ResponseEntity(new Respuesta(
                "Catalogo genero",
                true,
                service.getGeneroList()
        ),HttpStatus.OK);
    }

    @GetMapping("/estado-civil/catalog")
    public ResponseEntity<Respuesta> getEstadoCivil(){
        return new ResponseEntity(new Respuesta(
                "Catalogo estado civil",
                true,
                service.getEstadoCivilList()
        ),HttpStatus.OK);
    }
    @GetMapping("/regimen-marital/catalog")
    public ResponseEntity<Respuesta> getRegimenMarital(){
        return new ResponseEntity(new Respuesta(
                "Catalogo regimen marital",
                true,
                service.getRegimenMaritalList()
        ),HttpStatus.OK);
    }
    @GetMapping("/actividad-laboral/catalog")
    public ResponseEntity<Respuesta> getActividadLaboral(){
        return new ResponseEntity(new Respuesta(
                "Catalogo actidad laboral",
                true,
                service.getTipoActividadLaboralsList()
        ),HttpStatus.OK);
    }
    @GetMapping("/tipo-contrato/catalog")
    public ResponseEntity<Respuesta> getTipoContrato(){
        return new ResponseEntity(new Respuesta(
                "Catalogo tipo contrato",
                true,
                service.getTipoContratoList()
        ),HttpStatus.OK);
    }
    @GetMapping("/puesto/catalog")
    public ResponseEntity<Respuesta> getPusto(){
        return new ResponseEntity(new Respuesta(
                "Catalogo puesto",
                true,
                service.getTipoPuestoList()
        ),HttpStatus.OK);
    }
    @GetMapping("/tipo-referencial/catalog")
    public ResponseEntity<Respuesta> getTipoReferencia(){
        return new ResponseEntity(new Respuesta(
                "Catalogo tipo referencia",
                true,
                service.getTipoReferenciaList()
        ),HttpStatus.OK);
    }
}
