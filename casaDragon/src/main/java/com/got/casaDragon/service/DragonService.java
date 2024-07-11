package com.got.casaDragon.service;

import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.repositories.DragonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Dragon> buscarTodosDragones() throws Exception{
        try {
            return dragonRepository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Dragon buscarDragonPorId(Integer id) throws Exception{
        try {
            Optional<Dragon> dragonOptional = dragonRepository.findById(id);
            if (dragonOptional.isPresent()){
                return dragonOptional.get();
            }else {
                throw new Exception("Dragon no encontrado");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
