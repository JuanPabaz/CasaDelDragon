package com.got.casaDragon.controllers;

import com.got.casaDragon.models.Aliado;
import com.got.casaDragon.service.AliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aliado")
public class AliadoController {

    @Autowired
    private AliadoService aliadoService;

    @GetMapping()
    public ResponseEntity<?> encontrarTodosAliado() throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.FOUND).body(aliadoService.buscarTodosAliados());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{idAliado}")
    public ResponseEntity<?> buscarAliado(@PathVariable(name = "idAliado") Integer id) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.FOUND).body(aliadoService.buscarAliadoPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> guardarAliado(@RequestBody Aliado aliado) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(aliadoService.guardarAliado(aliado));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{idAliado}")
    public ResponseEntity<?> editarAliado(@PathVariable(name = "idAliado") Integer id,@RequestBody Aliado nuevoAliado) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(aliadoService.editarAliado(id,nuevoAliado));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idAliado}")
    public ResponseEntity<?> eliminarAliado(@PathVariable(name = "idAliado") Integer id) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(aliadoService.eliminarAliado(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
