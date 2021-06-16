package com.pma.pimacpt.model.tipos;

import javax.persistence.*;

@Entity
@Table(name = "type_laboral_activity")
public class TipoActividadLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_laboral_activity")
    private String idActidadLaboral;
    @Column(name = "description",length = 55, nullable = false)
    private String actidadLaboral;

    public String getIdActidadLaboral() {
        return idActidadLaboral;
    }

    public void setIdActidadLaboral(String idActidadLaboral) {
        this.idActidadLaboral = idActidadLaboral;
    }

    public String getActidadLaboral() {
        return actidadLaboral;
    }

    public void setActidadLaboral(String actidadLaboral) {
        this.actidadLaboral = actidadLaboral;
    }
}
