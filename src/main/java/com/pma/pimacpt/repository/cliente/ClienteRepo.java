package com.pma.pimacpt.repository.cliente;

import com.pma.pimacpt.model.cliente.Cliente;
import com.pma.pimacpt.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer> {
    Optional<Cliente> findClienByUser(User user);
}
