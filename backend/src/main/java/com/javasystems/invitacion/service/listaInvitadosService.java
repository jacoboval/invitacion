package com.javasystems.invitacion.service;

import com.javasystems.invitacion.model.listaInvitados;
import com.javasystems.invitacion.repository.listaInvitadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class listaInvitadosService {

    @Autowired
    private listaInvitadosRepository listaInvitadosRepository;


    public listaInvitados guardar(listaInvitados listaInvitados){
        return listaInvitadosRepository.save(listaInvitados);
    }
    /*
    public listaInvitados guardar(listaInvitados listainvitados){
        return listaInvitadosRepository.save(listainvitados);
    }*/

    public List<listaInvitados> listar(){
        return listaInvitadosRepository.findAll();
    }

    public Optional<listaInvitados> buscarInvitado(Long id){
        return listaInvitadosRepository.findById(id);
    }
    /*
    public Optional<listaInvitados> buscarInvitadoPorToken(Long id){
        return listaInvitadosRepository.findByToken(id);
    }

    public listaInvitados findByToken(String token) {
    }*/
}
