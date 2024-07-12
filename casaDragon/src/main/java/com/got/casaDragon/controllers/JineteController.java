package com.got.casaDragon.controllers;

import com.got.casaDragon.models.Jinete;
import com.got.casaDragon.service.JineteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jinete")
public class JineteController {

    @Autowired
    private JineteService jineteService;

    @GetMapping()
    public ResponseEntity<?> encontrarTodosJinete() throws Exception{
        return ResponseEntity.ok(jineteService.buscarTodosJinetes());
    }

    @GetMapping("/{idJinete}")
    public ResponseEntity<?> buscarJinete(@PathVariable(name = "idJinete") Integer id) throws Exception{
        return ResponseEntity.ok(jineteService.buscarJinetePorId(id));
    }

    @PostMapping()
    public ResponseEntity<?> guardarJinete(@RequestBody Jinete jinete) throws Exception{
        return ResponseEntity.ok(jineteService.guardarJinete(jinete));
    }

    @PutMapping("/{idJinete}")
    public ResponseEntity<?> editarJinete(@PathVariable(name = "idJinete") Integer id,@RequestBody Jinete nuevoJinete) throws Exception{
        return ResponseEntity.ok(jineteService.editarJinete(id,nuevoJinete));
    }

    @DeleteMapping("/{idJinete}")
    public ResponseEntity<?> eliminarJinete(@PathVariable(name = "idJinete") Integer id) throws Exception{
        return ResponseEntity.ok(jineteService.eliminarJinete(id));
    }
}
