package com.pma.pimacpt.model.tipos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gender")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private int idGenero;
    @Column(name = "description", nullable = false, length = 45)
    private String genero;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
