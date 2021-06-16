package com.pma.pimacpt.model.colonias;

import javax.persistence.*;

@Entity
@Table(name = "colonia")
public class Colonia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcolonia")
    private int idColonia;
    @Column(name = "descripcion",nullable = false,length = 65)
    private String nombreColonia;
    @Column(name = "cp",nullable = false,length = 7)
    private String codigoPostal;
    @ManyToOne
    @JoinColumn(name = "municipio",nullable = false)
    private Municipio municipio;

    public int getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(int idColonia) {
        this.idColonia = idColonia;
    }

    public String getNombreColonia() {
        return nombreColonia;
    }

    public void setNombreColonia(String nombreColonia) {
        this.nombreColonia = nombreColonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
