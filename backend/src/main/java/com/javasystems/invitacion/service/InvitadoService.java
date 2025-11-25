package com.javasystems.invitacion.service;

import com.javasystems.invitacion.model.Invitado;
import com.javasystems.invitacion.model.listaInvitados;
import com.javasystems.invitacion.repository.InvitadoRepository;
import com.javasystems.invitacion.repository.listaInvitadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvitadoService {


    @Autowired
    private InvitadoRepository invitadoRepository;


    public Invitado guardar(Invitado invitado){
        return invitadoRepository.save(invitado);
    }


    public List<Invitado> listar() {
        return invitadoRepository.findAll();
    }


    public Optional<Invitado> buscarInvitado(Long id){
        return invitadoRepository.findById(id);
    }

    public boolean eliminar(Long id){
        if(invitadoRepository.existsById(id)){
            invitadoRepository.deleteById(id);
            return true;
        }
        return  false;
    }
    public Invitado actualizar(Long id, Invitado datosActualizados){
        Invitado invitado = invitadoRepository.findById(id).orElse(null);
        if(invitado == null){
            return null;
        }
        invitado.setNombre(datosActualizados.getNombre());
        invitado.setAcompanantes(datosActualizados.getAcompanantes());
        invitado.setAsistencia(datosActualizados.getAsistencia());
        invitado.setMensaje(datosActualizados.getMensaje());

        return  invitadoRepository.save(invitado);
    }

    /*public Optional<Object> findById(Long id) {
    }*/
}
