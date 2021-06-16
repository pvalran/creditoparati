package com.pma.pimacpt.service.cliente;

import com.pma.pimacpt.model.tipos.*;
import com.pma.pimacpt.repository.colonia.NationalityRepo;
import com.pma.pimacpt.repository.tipo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoService {
    @Autowired
    private TipoDatosPersonalRepo tipoDatosPersonalRepo;
    @Autowired
    private TipoDocumentoRepo tipoDocumentoRepo;
    @Autowired
    private GeneroRepo generoRepo;
    @Autowired
    private EstadoCilvilRepo estadoCilvilRepo;
    @Autowired
    private NationalityRepo nationalityRepo;
    @Autowired
    private RegimenMaritalRepo regimenMaritalRepo;
    @Autowired
    private TipoActidadLaboralRepo tipoActidadLaboralRepo;
    @Autowired
    private TipoContratoRepo tipoContratoRepo;
    @Autowired
    private TipoPuestoRepo tipoPuestoRepo;
    @Autowired
    private TipoReferenciaRepo tipoReferenciaRepo;

    public List<TipoDatoPersonal> getALLTipoDatoPersonal(){
        return tipoDatosPersonalRepo.findAll();
    }

    public boolean saveTipoDatosPersonal(TipoDatoPersonal tipo){
        TipoDatoPersonal resp= tipoDatosPersonalRepo.save(tipo);
        if(resp.getTipo().equals(tipo.getTipo())){
            return true;
        }
        return false;
    }

    public List<TipoDocumento> getAllTipoDocumento(){
        return tipoDocumentoRepo.findAll();
    }

    public boolean saveTipoDocumento(TipoDocumento tipo){
        TipoDocumento resp= tipoDocumentoRepo.save(tipo);
        if(resp.getDescription().equals(tipo.getDescription())){
            return true;
        }
        return false;
    }

    public List<Genero> getGeneroList () {
        return generoRepo.findAll();
    }

    public List<EstadoCivil> getEstadoCivilList () {
        return estadoCilvilRepo.findAll();
    }

    public List<RegimenMarital> getRegimenMaritalList () {
        return regimenMaritalRepo.findAll();
    }

    public List<TipoActividadLaboral> getTipoActividadLaboralsList () {
        return  tipoActidadLaboralRepo.findAll();
    }

    public List<TipoContrato> getTipoContratoList () {
        return tipoContratoRepo.findAll();
    }

    public List<TipoPuesto> getTipoPuestoList () {
        return tipoPuestoRepo.findAll();
    }

    public List<TipoReferencia> getTipoReferenciaList () {
        return tipoReferenciaRepo.findAll();
    }

}
