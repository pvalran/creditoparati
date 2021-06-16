package com.pma.pimacpt.model.tipos;

import javax.persistence.*;

@Entity
@Table(name = "type_contract")
public class TipoContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_contract")
    private int idTipoContrato;
    @Column(name = "description", length = 55, nullable = false)
    private String tipoContrato;

    public int getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(int idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
