package com.got.casaDragon.service;

import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.repositories.DragonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DragonService {

    @Autowired
    private DragonRepository dragonRepository;

    public Dragon agregarDragon(Dragon dragon) throws Exception{
        try {
            return dragonRepository.save(dragon);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
