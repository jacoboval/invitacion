package com.javasystems.invitacion.repository;

import com.javasystems.invitacion.model.Invitado;
import com.javasystems.invitacion.model.listaInvitados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface listaInvitadosRepository extends JpaRepository<listaInvitados, Long> {

/*
    Invitado findByToken(String token);
    */

}
