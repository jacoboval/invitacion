package com.javasystems.invitacion.controller;

import com.javasystems.invitacion.model.Invitado;
import com.javasystems.invitacion.repository.InvitadoRepository;
import com.javasystems.invitacion.service.InvitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rsvp")

@CrossOrigin(origins = "*")

public class InvitadoController {
    @Autowired
    //private InvitadoRepository repositorio;
    private InvitadoService invitadoService;

    @PostMapping
    public ResponseEntity<Invitado> crearInvitado(@RequestBody Invitado invitado){
        Invitado nuevo = invitadoService.guardar(invitado);
        return  ResponseEntity.ok(nuevo);
    }

    @GetMapping("/listar")
    public ResponseEntity <List<Invitado>>Invitados() {
        List<Invitado> invitados= invitadoService.listar();
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
    public ResponseEntity<Invitado> actualizarInvitado(
            @PathVariable Long id,
            @RequestBody Invitado invitadoActualizado) {

        Invitado actualizado = invitadoService.actualizar(id, invitadoActualizado);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }
}