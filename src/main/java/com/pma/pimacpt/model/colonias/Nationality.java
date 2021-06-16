package com.pma.pimacpt.model.colonias;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nationality")
public class Nationality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nationality")
    private int idNationality;
    @Column(name = "description",length = 45,nullable = false)
    private String nacionalidad;

    public Nationality defaultNacionaty(){
        idNationality=1;
        return this;
    }

    public int getIdNationality() {
        return idNationality;
    }

    public void setIdNationality(int idNationality) {
        this.idNationality = idNationality;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
