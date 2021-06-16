package com.pma.pimacpt.model.tipos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "type_cilvil")
public class EstadoCivil {
    @Id
    @Column(name = "id_type_cilvil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadoCivil;
    @Column(name = "description",length = 45,nullable = false)
    private String estadoCivil;

    public EstadoCivil defaultEstadoCivil(){
        idEstadoCivil=1;
        return this;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
