package com.got.casaDragon.controllers;

import com.got.casaDragon.DTO.JineteDTO;
import com.got.casaDragon.models.Jinete;
import com.got.casaDragon.service.JineteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jinete")
@Tag(name = "Servicios Jinete",description = "Servicios asociados a la tabla jinete de la base de datos Dragones")
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
    @Operation(
            summary = "Registra un jinete nuevo en la base de datos",
            description = "Al llevar nombre, edad, fecha montura se registra con exito el jinete"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Jinete registrado con exito en la BD",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JineteDTO.class),
                                    examples = @ExampleObject(value = "{\"nombreJinete\":\"Wisin\",\"edad\":\"20\"}")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error al registrar el Jinete",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class),
                                    examples = @ExampleObject(value = "{\"error\":\"Datos invalidos\"}")
                            ))
            }
    )
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
