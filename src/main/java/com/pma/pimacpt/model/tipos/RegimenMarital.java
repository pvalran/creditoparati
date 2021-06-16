package com.pma.pimacpt.model.tipos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "marital_status")
public class RegimenMarital {
    @Id
    @Column(name = "id_marital_status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegimenMarital;
    @Column(name = "description",length = 45,nullable = false)
    private String regimenMarital;

    public RegimenMarital defaultRegimenMarital(){
        this.idRegimenMarital=1;
        return this;
    }

    public int getIdRegimenMarital() {
        return idRegimenMarital;
    }

    public void setIdRegimenMarital(int idRegimenMarital) {
        this.idRegimenMarital = idRegimenMarital;
    }

    public String getRegimenMarital() {
        return regimenMarital;
    }

    public void setRegimenMarital(String regimenMarital) {
        this.regimenMarital = regimenMarital;
    }
}
