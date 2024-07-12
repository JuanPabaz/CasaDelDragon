package com.got.casaDragon.controllers;

import com.got.casaDragon.models.Aliado;
import com.got.casaDragon.service.AliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aliado")
public class AliadoController {

    @Autowired
    private AliadoService aliadoService;

    @GetMapping()
    public ResponseEntity<?> encontrarTodosAliado() throws Exception{
        return ResponseEntity.ok(aliadoService.buscarTodosAliados());
    }

    @GetMapping("/{idAliado}")
    public ResponseEntity<?> buscarAliado(@PathVariable(name = "idAliado") Integer id) throws Exception{
        return ResponseEntity.ok(aliadoService.buscarAliadoPorId(id));
    }

    @PostMapping()
    public ResponseEntity<?> guardarAliado(@RequestBody Aliado aliado) throws Exception{
        return ResponseEntity.ok(aliadoService.guardarAliado(aliado));
    }

    @PutMapping("/{idAliado}")
    public ResponseEntity<?> editarAliado(@PathVariable(name = "idAliado") Integer id,@RequestBody Aliado nuevoAliado) throws Exception{
        return ResponseEntity.ok(aliadoService.editarAliado(id,nuevoAliado));
    }

    @DeleteMapping("/{idAliado}")
    public ResponseEntity<?> eliminarAliado(@PathVariable(name = "idAliado") Integer id) throws Exception{
        return ResponseEntity.ok(aliadoService.eliminarAliado(id));
    }


}
