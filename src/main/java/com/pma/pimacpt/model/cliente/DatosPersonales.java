package com.pma.pimacpt.model.cliente;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pma.pimacpt.model.tipos.TipoDatoPersonal;

import javax.persistence.*;

@Entity
@Table(name = "personal_data_client")
public class DatosPersonales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal_data_client")
    private int idDatoPersonal;
    @Column(name = "data",nullable = false,length = 254)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "client",nullable = false)
    @JsonBackReference
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "type_data",nullable = false)
    private TipoDatoPersonal tipoDato;

    public DatosPersonales() {
    }

    public DatosPersonales(String descripcion, Cliente cliente, TipoDatoPersonal tipoDato) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.tipoDato = tipoDato;
    }

    public int getIdDatoPersonal() {
        return idDatoPersonal;
    }

    public void setIdDatoPersonal(int idDatoPersonal) {
        this.idDatoPersonal = idDatoPersonal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoDatoPersonal getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(TipoDatoPersonal tipoDato) {
        this.tipoDato = tipoDato;
    }
}
