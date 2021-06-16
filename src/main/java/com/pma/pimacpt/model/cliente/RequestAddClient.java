package com.pma.pimacpt.model.cliente;

import com.pma.pimacpt.model.colonias.Colonia;
import com.pma.pimacpt.model.colonias.Estado;
import com.pma.pimacpt.model.tipos.Genero;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

public class RequestAddClient {
    @NotBlank(message = "name es requerido")
    private String name;
    @NotBlank(message = "apellidoMaterno es requerido")
    private String apellidoMaterno;
    @NotBlank(message = "apellidoPaterno es requerido")
    private String apellidoPaterno;
    @NotNull(message = "fechaNacimiento es requerido")
    private Calendar fechaNacimiento;
    @NotBlank(message = "curp es requerido")
    private String curp;
    @NotBlank(message = "rfc es requerido")
    private String rfc;
    @NotNull(message = "edad es requerido")
    private Integer edad;
    @NotNull(message = "estadoNacimiento es requerido")
    private Estado estadoNacimiento;
    @NotBlank(message = "email es requerido")
    @Email
    private String email;
    @NotBlank(message = "calle es requerido")
    private String calle;
    @NotBlank(message = "numero es requerido")
    private String numero;
    private String numInterior;
    @NotNull(message = "colonia es requerido")
    private Colonia colonia;
    @NotNull(message = "genero es requerido")
    private Genero genero;

    public String getName() {
        return name;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public String getRfc() {
        return rfc;
    }

    public Integer getEdad() {
        return edad;
    }

    public Estado getEstadoNacimiento() {
        return estadoNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public Genero getGenero() {
        return genero;
    }
}
