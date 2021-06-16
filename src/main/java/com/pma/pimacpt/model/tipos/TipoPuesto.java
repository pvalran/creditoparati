package com.pma.pimacpt.model.tipos;

import javax.persistence.*;

@Entity
@Table(name = "type_position")
public class TipoPuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_position")
    private int idTipoPuesto;
    @Column(name = "description", length = 55, nullable = false)
    private String puesto;

    public int getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(int idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
