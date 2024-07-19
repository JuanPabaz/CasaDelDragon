package com.got.casaDragon.controllers;

import com.got.casaDragon.DTO.DragonDTO;
import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.service.DragonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DragonControllerTest {

    @Mock
    private DragonService dragonService;

    @InjectMocks
    private DragonController dragonController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void guardarDragonDevuelveDragonDto() throws Exception{
        //Arrange
        DragonDTO dragonDTO = new DragonDTO();
        //Cuando algo se ejecuta que retorno
        when(dragonService.agregarDragon(any(Dragon.class))).thenReturn(dragonDTO);

        //Act (Donde llamo al metodo que quiero probar)
        Dragon dragon = new Dragon();
        ResponseEntity<?> response = dragonController.guardarDragon(dragon);

        //Assert
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertEquals(dragonDTO,response.getBody());
    }

    public void guardarDragonOcurreUnErrorDevuelveUnMensaje() throws Exception{

    }
}