package com.pma.pimacpt.model.tipos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "type_datos")
public class TipoDatoPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_datos")
    private int idTipoDato;
    @NotNull
    @Column(name = "description",nullable = false, length = 45)
    private String tipo;

    public int getIdTipoDato() {
        return idTipoDato;
    }

    public void setIdTipoDato(int idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
