package com.javasystems.invitacion.controller;

import com.javasystems.invitacion.model.InvitadoConfirmado;
import com.javasystems.invitacion.service.InvitadoConfirmadoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ResponseEntity<InvitadoConfirmado> crearInvitado(@RequestBody InvitadoConfirmado invitado){
        InvitadoConfirmado nuevo = invitadoService.guardar(invitado);
        return  ResponseEntity.ok(nuevo);
    }

    @GetMapping("/listar")
    public ResponseEntity <List<InvitadoConfirmado>>Invitados() {
        List<InvitadoConfirmado> invitados= invitadoService.listar();
        return ResponseEntity.ok(invitados);
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