package com.pma.pimacpt.controller;

import com.pma.pimacpt.dto.Respuesta;
import com.pma.pimacpt.model.cliente.Cliente;
import com.pma.pimacpt.model.cliente.DatosPersonales;
import com.pma.pimacpt.model.cliente.RequestAddClient;
import com.pma.pimacpt.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClienteService service;

    @PostMapping("/addClient")
    public ResponseEntity<?> addClient(@Valid @RequestBody Cliente cliente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(
                    new Respuesta(
                            "Verifique datos enviados del cliente",
                            false,
                            bindingResult.getFieldError()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
        if(!service.createClient(cliente)){
            return new ResponseEntity(
                    new Respuesta(
                            "Error verifique datos del cliente",
                            false,
                            bindingResult.getSuppressedFields()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity(
                new Respuesta(
                        "Cliente guardado",
                        true,
                        null
                ),
                HttpStatus.CREATED
        );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/getClientById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getClientById(@PathVariable("id") Integer idCliente){
        Cliente cliente=service.getCliente(idCliente);
        return new ResponseEntity(
                new Respuesta(
                        "Client",
                        true,
                        cliente
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/getClient")
    public ResponseEntity<Respuesta> getClient(){
        Cliente cliente;
        try {
            cliente=service.getCliente();

        }
        catch (NoSuchElementException e){
            return new ResponseEntity(
                    new Respuesta(
                            "No existe cliente para el usuario",
                            false,
                            e.getMessage()
                    ),
                    HttpStatus.FORBIDDEN
            );
        }
        return new ResponseEntity(
                new Respuesta(
                        "Cliente",
                        true,
                        cliente
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/addPesonalData")
    public ResponseEntity<Respuesta> addDatos(@Valid @RequestBody DatosPersonales datosPersonales){
        try {
            if (service.addPersonalData(datosPersonales)) {
                return new ResponseEntity(new Respuesta(
                        "Agregado",
                        true,
                        "Saved"
                ), HttpStatus.OK);
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(new Respuesta(
                    "Algo salio mal",
                    false,
                    e.getMessage()
            ),HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(new Respuesta(
                "Algo salio mal",
                false,
                "No guardado"
        ),HttpStatus.FORBIDDEN);
    }

    @GetMapping("/getCatalogoDatos")
    public ResponseEntity<Respuesta> getCatalogosTipoDato(){
        return new ResponseEntity(
                new Respuesta(
                        "Catalogo datos personales",
                        true,
                        service.getCatalogoDatosPersonal()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/add-client-form")
    public ResponseEntity<Respuesta> addClientForm(@Valid @RequestBody RequestAddClient request,
                                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(
                    new Respuesta(
                            "Verifique datos enviados",
                            false,
                            bindingResult.getFieldError()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }

        Cliente cliente= service.addClientByForm(request);

        return new ResponseEntity(
                new Respuesta(
                        "Cliente guardado",
                        true,
                        cliente
                ),
                HttpStatus.CREATED
        );
    }
}
