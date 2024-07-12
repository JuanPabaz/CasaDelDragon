package com.got.casaDragon.controllers;

import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.service.DragonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dragon")
public class DragonController {

    @Autowired
    private DragonService dragonService;

    @GetMapping()
    public ResponseEntity<?> encontrarTodosDragon() throws Exception{
        return ResponseEntity.ok(dragonService.buscarTodosDragones());
    }

    @GetMapping("/{idDragon}")
    public ResponseEntity<?> buscarDragon(@PathVariable(name = "idDragon") Integer id) throws Exception{
        return ResponseEntity.ok(dragonService.buscarDragonPorId(id));
    }

    @PostMapping()
    public ResponseEntity<?> guardarDragon(@RequestBody Dragon dragon) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(dragonService.agregarDragon(dragon));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{idJinete}")
    public ResponseEntity<?> editarDragon(@PathVariable(name = "idDragon") Integer id,@RequestBody Dragon nuevoDragon) throws Exception{
        return ResponseEntity.ok(dragonService.editarDragon(id,nuevoDragon));
    }

    @DeleteMapping("/{idJinete}")
    public ResponseEntity<?> eliminarDragon(@PathVariable(name = "idDragon") Integer id) throws Exception{
        return ResponseEntity.ok(dragonService.eliminarDragon(id));
    }

}
