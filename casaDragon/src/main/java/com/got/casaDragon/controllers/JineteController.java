package com.got.casaDragon.controllers;

import com.got.casaDragon.models.Jinete;
import com.got.casaDragon.service.JineteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jinete")
public class JineteController {

    @Autowired
    private JineteService jineteService;

    @GetMapping()
    public ResponseEntity<?> encontrarTodosJinete(){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(jineteService.buscarTodosJinetes());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{idJinete}")
    public ResponseEntity<?> buscarJinete(@PathVariable(name = "idJinete") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(jineteService.buscarJinetePorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> guardarJinete(@RequestBody Jinete jinete){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(jineteService.guardarJinete(jinete));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{idJinete}")
    public ResponseEntity<?> editarJinete(@PathVariable(name = "idJinete") Integer id,@RequestBody Jinete nuevoJinete){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(jineteService.editarJinete(id,nuevoJinete));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idJinete}")
    public ResponseEntity<?> eliminarJinete(@PathVariable(name = "idJinete") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(jineteService.eliminarJinete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
