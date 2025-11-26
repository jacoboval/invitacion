package com.javasystems.invitacion.service;

import com.javasystems.invitacion.model.listaInvitados;
import com.javasystems.invitacion.repository.listaInvitadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class listaInvitadosService {

    @Autowired
    private listaInvitadosRepository listaInvitadosRepository;


    public listaInvitados crearInvitado(listaInvitados listaInvitados) {
        listaInvitados.setTokenAcceso(UUID.randomUUID().toString());
        return listaInvitadosRepository.save(listaInvitados);
    }


    public List<listaInvitados> listar(){
        return listaInvitadosRepository.findAll();
    }

    public Optional<listaInvitados> buscarInvitado(Long id){
        return listaInvitadosRepository.findById(id);
    }

}
