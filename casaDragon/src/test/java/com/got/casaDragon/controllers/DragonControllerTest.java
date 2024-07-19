package com.got.casaDragon.controllers;

import com.got.casaDragon.DTO.DragonDTO;
import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.service.DragonService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

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

    public void guardarDragonDevuelveDragonDto() throws Exception{
        //arrange
        DragonDTO dragonDTO = new DragonDTO();
        when(dragonService.agregarDragon(any(Dragon.class)));
    }
}