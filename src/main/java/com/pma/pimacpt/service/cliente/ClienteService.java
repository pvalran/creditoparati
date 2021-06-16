package com.pma.pimacpt.service.cliente;

import com.pma.pimacpt.model.cliente.Cliente;
import com.pma.pimacpt.model.cliente.DatosPersonales;
import com.pma.pimacpt.model.cliente.RequestAddClient;
import com.pma.pimacpt.model.colonias.Nationality;
import com.pma.pimacpt.model.tipos.EstadoCivil;
import com.pma.pimacpt.model.tipos.RegimenMarital;
import com.pma.pimacpt.model.tipos.TipoDatoPersonal;
import com.pma.pimacpt.model.user.User;
import com.pma.pimacpt.repository.cliente.ClienteRepo;
import com.pma.pimacpt.repository.cliente.DatosPersonalesRepo;
import com.pma.pimacpt.repository.tipo.TipoDatosPersonalRepo;
import com.pma.pimacpt.repository.user.UserRepository;
import com.pma.pimacpt.security.jwt.JwtProvider;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DatosPersonalesRepo datosRepo;
    @Autowired
    private TipoDatosPersonalRepo catalogoRepo;
    @Autowired
    private JwtProvider jwtProvider;

    public boolean createClient(Cliente cliente){
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUserName(userDetails.getUsername()).get();
        cliente.setUser(user);
        Cliente cli= clienteRepo.save(cliente);
        return cli.getApellidoMaterno().equals(cliente.getApellidoMaterno())&&cli.getApellidoPaterno().equals(cliente.getApellidoPaterno());
    }

    public Cliente getCliente(Integer cliente){
        List<Cliente> list=new ArrayList<>();
        clienteRepo.findById(cliente).ifPresent(list::add);
        return list.get(0);
    }

    public Cliente getCliente() throws NoSuchElementException {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUserName(userDetails.getUsername()).get();
        return clienteRepo.findClienByUser(user).get();
    }

    public boolean addPersonalData(DatosPersonales datosPersonales) throws NoSuchElementException{
        if(!clienteRepo.existsById(datosPersonales.getCliente().getIdCliente())){
            throw new NoSuchElementException("Client doesn't exist");
        }
        DatosPersonales personales= datosRepo.save(datosPersonales);
        return personales.getDescripcion().equals(datosPersonales.getDescripcion());
    }

    public List<TipoDatoPersonal> getCatalogoDatosPersonal(){
        return catalogoRepo.findAll();
    }

    public Cliente addClientByForm(RequestAddClient request){
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUserName(userDetails.getUsername()).get();
        Cliente cliente=new Cliente(
                request.getName(),
                request.getApellidoMaterno(),
                request.getApellidoPaterno(),
                request.getCalle(),
                request.getNumero(),
                request.getNumInterior()!=null?request.getNumInterior():"",
                request.getFechaNacimiento(),
                request.getColonia(),
                request.getGenero(),
                new Nationality().defaultNacionaty(),
                new RegimenMarital().defaultRegimenMarital(),
                new EstadoCivil().defaultEstadoCivil(),
                request.getEstadoNacimiento(),
                user
        );

        Cliente clienteCreado= clienteRepo.save(cliente);
        TipoDatoPersonal datpType=new TipoDatoPersonal();
        datpType.setIdTipoDato(1);
        DatosPersonales curp= new DatosPersonales(
                request.getCurp(),
                clienteCreado,
                datpType
        );
        datosRepo.save(curp);
        datpType.setIdTipoDato(2);
        DatosPersonales rfc= new DatosPersonales(
                request.getRfc(),
                clienteCreado,
                datpType
        );
        datosRepo.save(rfc);
        datpType.setIdTipoDato(3);
        DatosPersonales email= new DatosPersonales(
                request.getEmail(),
                clienteCreado,
                datpType
        );
        datosRepo.save(email);

        return clienteCreado;
    }
}
