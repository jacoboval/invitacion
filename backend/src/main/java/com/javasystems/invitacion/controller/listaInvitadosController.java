package com.javasystems.invitacion.controller;

import com.javasystems.invitacion.model.listaInvitados;
import com.javasystems.invitacion.service.listaInvitadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping("/admin")

@CrossOrigin(origins = "*")
public class listaInvitadosController {

    @Autowired
    private listaInvitadosService listaInvitadosService;


    //  crear invitado en la lista de invitados
    @PostMapping
    public ResponseEntity<listaInvitados> agregarAListadeInvitados(@RequestBody listaInvitados listaInvitados){
        listaInvitados nuevo = listaInvitadosService.guardar(listaInvitados);
        return  ResponseEntity.ok(nuevo);
    }


    @GetMapping("/listarInvitados")
    public ResponseEntity<List<listaInvitados>>listarInvitados(){
        List <listaInvitados> listaInvitados = listaInvitadosService.listar();
        return ResponseEntity.ok(listaInvitados);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<listaInvitados> ObtenerPorId(@PathVariable Long id) {
        return listaInvitadosService.buscarInvitado(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    /*
    @GetMapping("/vista/{token}")
    public ResponseEntity<Invitado> cargarInvitadoPorToken(@PathVariable String token) {
        Invitado invitado = listaInvitadosRepository.findByToken(token);
        if (invitado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(invitado);
    }

     */


}
