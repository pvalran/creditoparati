package com.pma.pimacpt.model.cliente;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pma.pimacpt.model.tipos.TipoDatoPersonal;
import com.pma.pimacpt.model.tipos.TipoDocumento;

import javax.persistence.*;

@Entity
@Table(name = "documentation_cliente")
public class Documentacion {
    @Id
    @Column(name = "id_documentacion_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumentacion;
    @Column(name = "document",nullable = false)
    private String documentBase64;
    @Column(name = "format",nullable = false,length = 15)
    private String formato;
    @ManyToOne
    @JoinColumn(name = "cliente",nullable = false)
    @JsonBackReference
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "tipo",nullable = false)
    private TipoDocumento tipoDocumento;

    public Documentacion() {
    }

    public Documentacion(int idDocumentacion, String documentBase64, String formato, Cliente cliente, TipoDocumento tipoDocumento) {
        this.idDocumentacion = idDocumentacion;
        this.documentBase64 = documentBase64;
        this.formato = formato;
        this.cliente = cliente;
        this.tipoDocumento = tipoDocumento;
    }

    public int getIdDocumentacion() {
        return idDocumentacion;
    }

    public void setIdDocumentacion(int idDocumentacion) {
        this.idDocumentacion = idDocumentacion;
    }

    public String getDocumentBase64() {
        return documentBase64;
    }

    public void setDocumentBase64(String documentBase64) {
        this.documentBase64 = documentBase64;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
