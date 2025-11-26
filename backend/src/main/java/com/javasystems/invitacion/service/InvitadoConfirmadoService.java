package com.javasystems.invitacion.service;

import com.javasystems.invitacion.model.InvitadoConfirmado;
import com.javasystems.invitacion.repository.InvitadoConfirmadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvitadoConfirmadoService {


    @Autowired
    private InvitadoConfirmadoRepository invitadoRepository;


    public InvitadoConfirmado guardar(InvitadoConfirmado invitado){

        return invitadoRepository.save(invitado);
    }


    public List<InvitadoConfirmado> listar() {
        return invitadoRepository.findAll();
    }


    public Optional<InvitadoConfirmado> buscarInvitado(Long id){
        return invitadoRepository.findById(id);
    }

    public boolean eliminar(Long id){
        if(invitadoRepository.existsById(id)){
            invitadoRepository.deleteById(id);
            return true;
        }
        return  false;
    }
    public InvitadoConfirmado actualizar(Long id, InvitadoConfirmado datosActualizados){
        InvitadoConfirmado invitado = invitadoRepository.findById(id).orElse(null);
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
