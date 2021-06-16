package com.pma.pimacpt.model.tipos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "type_document")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_document")
    private int idTipoDocument;
    @NotNull
    @Column(name = "description", length = 45, nullable = false)
    private String description;

    public int getIdTipoDocument() {
        return idTipoDocument;
    }

    public void setIdTipoDocument(int idTipoDocument) {
        this.idTipoDocument = idTipoDocument;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
