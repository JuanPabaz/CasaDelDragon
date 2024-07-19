package com.got.casaDragon.controllers;

import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.service.DragonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/dragon")
@Tag(name = "Servicios Dragon",description = "Servicios asociados a la tabla dragon de la base de datos Dragones")
public class DragonController {

    @Autowired
    private DragonService dragonService;

    @GetMapping()
    public ResponseEntity<?> encontrarTodosDragon(){
        try {
            return ResponseEntity.ok(dragonService.buscarTodosDragones());
        }catch (Exception e){
            Map<String,Object> mensajeError = new HashMap<>();
            mensajeError.put("error",e.getMessage());
            mensajeError.put("timeStamp", LocalDate.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @GetMapping("/{idDragon}")
    public ResponseEntity<?> buscarDragon(@PathVariable(name = "idDragon") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(dragonService.buscarDragonPorId(id));
        }catch (Exception e){
            Map<String,Object> mensajeError = new HashMap<>();
            mensajeError.put("error",e.getMessage());
            mensajeError.put("timeStamp", LocalDate.now());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError);
        }
    }

    @PostMapping()
    public ResponseEntity<?> guardarDragon(@RequestBody Dragon dragon){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(dragonService.agregarDragon(dragon));
        }catch (Exception e){
            Map<String,Object> mensajeError = new HashMap<>();
            mensajeError.put("error",e.getMessage());
            mensajeError.put("timeStamp", LocalDate.now());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError);
        }
    }

    @PutMapping("/{idDragon}")
    public ResponseEntity<?> editarDragon(@PathVariable(name = "idDragon") Integer id,@RequestBody Dragon nuevoDragon){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dragonService.editarDragon(id,nuevoDragon));
        }catch (Exception e){
            Map<String,Object> mensajeError = new HashMap<>();
            mensajeError.put("error",e.getMessage());
            mensajeError.put("timeStamp", LocalDate.now());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensajeError);
        }
    }

    @DeleteMapping("/{idDragon}")
    public ResponseEntity<?> eliminarDragon(@PathVariable(name = "idDragon") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dragonService.eliminarDragon(id));
        }catch (Exception e){
            Map<String,Object> mensajeError = new HashMap<>();
            mensajeError.put("error",e.getMessage());
            mensajeError.put("timeStamp", LocalDate.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

}
