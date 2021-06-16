package com.pma.pimacpt.model.tipos;

import javax.persistence.*;

@Entity
@Table(name = "type_reference")
public class TipoReferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_reference")
    private int idTipoReferencia;
    @Column(name = "description", length = 51, nullable = false)
    private String tipoReferencia;

    public int getIdTipoReferencia() {
        return idTipoReferencia;
    }

    public void setIdTipoReferencia(int idTipoReferencia) {
        this.idTipoReferencia = idTipoReferencia;
    }

    public String getTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(String tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }
}
