package com.javasystems.invitacion.controller;

import com.javasystems.invitacion.model.InvitadoConfirmado;
import com.javasystems.invitacion.model.listaInvitados;
import com.javasystems.invitacion.repository.InvitadoConfirmadoRepository;
import com.javasystems.invitacion.repository.listaInvitadosRepository;
import com.javasystems.invitacion.service.InvitadoConfirmadoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//ic - invitados confirmados
@RequestMapping("/ic")

@CrossOrigin(origins = "*")

public class InvitadoConfirmadoController {
    @Autowired
    //private InvitadoRepository repositorio;
    private InvitadoConfirmadoService invitadoService;
    @Autowired
    private InvitadoConfirmadoRepository invitadoConfirmadoRepository;
    @Autowired
    private listaInvitadosRepository listaInvitadosRepository;

    /*
    @PostMapping
    public ResponseEntity<?> confirmar(@RequestBody InvitadoConfirmado invitadoData) {

        //InvitadoConfirmado invitadoDB = listaInvitadosRepository.findByTokenAcceso(invitadoData.getTokenAcceso());
        listaInvitados invitadoDB = com.javasystems.invitacion.repository.listaInvitadosRepository.findByTokenAcceso(invitadoData.getTokenAcceso());


        if (invitadoDB == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Token inválido");
        }

        if (invitadoDB.isConfirmado()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ya registraste tu confirmación.");
        }

        // Guardar la confirmación
        invitadoDB.setNombre(invitadoData.getNombre());
        invitadoDB.setAcompanantes(invitadoData.getAcompanantes());
        invitadoDB.setAsistencia(invitadoData.getAsistencia());
        invitadoDB.setMensaje(invitadoData.getMensaje());
        invitadoDB.setConfirmado(true);
        listaInvitadosRepository.save(invitadoDB);

        return ResponseEntity.ok("Confirmación guardada correctamente.");
    }
    */

    @PostMapping
    public ResponseEntity<InvitadoConfirmado> crearInvitado(@RequestBody InvitadoConfirmado invitado){
        InvitadoConfirmado nuevo = invitadoService.guardar(invitado);
        return  ResponseEntity.ok(nuevo);
    }

    @GetMapping("/listar")
    public ResponseEntity <List<InvitadoConfirmado>>InvitadoConfirmado() {
        List<InvitadoConfirmado> invitadocpnfirmado= invitadoService.listar();
        return ResponseEntity.ok(invitadocpnfirmado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        if(invitadoService.eliminar(id)){
            return ResponseEntity.ok("Envitado eliminado correctamente");
        }else {
            return ResponseEntity.status(404).body("invitado no encontrado.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvitadoConfirmado> actualizarInvitado(
            @PathVariable Long id,
            @RequestBody InvitadoConfirmado invitadoActualizado) {

        InvitadoConfirmado actualizado = invitadoService.actualizar(id, invitadoActualizado);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }
}