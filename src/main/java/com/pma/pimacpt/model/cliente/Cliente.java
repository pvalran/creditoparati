package com.pma.pimacpt.model.cliente;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pma.pimacpt.model.colonias.Colonia;
import com.pma.pimacpt.model.colonias.Estado;
import com.pma.pimacpt.model.colonias.Nationality;
import com.pma.pimacpt.model.tipos.EstadoCivil;
import com.pma.pimacpt.model.tipos.Genero;
import com.pma.pimacpt.model.tipos.RegimenMarital;
import com.pma.pimacpt.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Table(name = "client")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idCliente;
    @Column(name = "name", length = 150, nullable = false)
    private String name;
    @Column(name = "materno", length = 150, nullable = false)
    private String apellidoMaterno;
    @Column(name = "paterno", length = 150, nullable = false)
    private String apellidoPaterno;
    @Column(name = "street",nullable = false, length = 65)
    private String calle;
    @Column(name = "number", nullable = false, length = 15)
    private String numero;
    @Column(name = "interior",nullable = false,length = 15)
    private String numInterior;
    @Column(name = "born", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar nacimiento;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "suburb",nullable = false)
    private Colonia colonia;
    @ManyToOne
    @JoinColumn(name = "gender",nullable = false)
    private Genero genero;
    @ManyToOne
    @JoinColumn(name = "nationality",nullable = false)
    private Nationality nationality;
    @ManyToOne
    @JoinColumn(name = "marital_status",nullable = false)
    private RegimenMarital regimenMarital;
    @ManyToOne
    @JoinColumn(name = "civil_type",nullable = false)
    private EstadoCivil estadoCivil;
    @ManyToOne
    @JoinColumn(name = "user",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "born_in",nullable = false)
    private Estado estadoNacimiento;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DatosPersonales> datosPersonales;
    /*@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Documentacion> documentacionList;*/


    public Cliente() {
    }

    public Cliente(String name, String apellidoMaterno, String apellidoPaterno, String calle, String numero, String numInterior, Calendar nacimiento, @NotNull Colonia colonia, Genero genero, Nationality nationality, RegimenMarital regimenMarital, EstadoCivil estadoCivil, Estado bornIn, User user) {
        this.name = name;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.calle = calle;
        this.numero = numero;
        this.numInterior = numInterior;
        this.nacimiento = nacimiento;
        this.colonia = colonia;
        this.genero = genero;
        this.nationality = nationality;
        this.regimenMarital = regimenMarital;
        this.estadoCivil = estadoCivil;
        this.user = user;
        this.estadoNacimiento = bornIn;
    }

    public Calendar getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Calendar nacimiento) {
        this.nacimiento = nacimiento;
    }

    /*public List<Documentacion> getDocumentacionList() {
        return documentacionList;
    }

    public void setDocumentacionList(List<Documentacion> documentacionList) {
        this.documentacionList = documentacionList;
    }*/

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public RegimenMarital getRegimenMarital() {
        return regimenMarital;
    }

    public void setRegimenMarital(RegimenMarital regimenMarital) {
        this.regimenMarital = regimenMarital;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<DatosPersonales> getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(List<DatosPersonales> datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
