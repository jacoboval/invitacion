package com.javasystems.invitacion.repository;

import com.javasystems.invitacion.model.Invitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitadoRepository extends JpaRepository<Invitado,Long> {


}
