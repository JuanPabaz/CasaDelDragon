package com.got.casaDragon.service;

import com.got.casaDragon.DTO.DragonDTO;
import com.got.casaDragon.helpers.MensajeServicios;
import com.got.casaDragon.helpers.validations.DragonValidations;
import com.got.casaDragon.maps.IMapDragon;
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

    @Autowired
    private IMapDragon mapDragon;

    @Autowired
    private DragonValidations dragonValidations;

    public DragonDTO agregarDragon(Dragon dragon) throws Exception{
        try {
            if (!dragonValidations.validarNombreDragon(dragon.getNombreDragon())){
                throw new Exception("El nombre debe ser menor de 20 caracteres");
            }

            if (!dragonValidations.validarEdad(dragon.getEdad())){
                throw new Exception("La edad tiene que ser mayor o igual a 0 y menor a 2000");
            }

            if (!dragonValidations.validarAltura(dragon.getAltura())){
                throw new Exception("La altura tiene que ser positiva mayor que 0");
            }

            if (!dragonValidations.validarNumeroVictorias(dragon.getNumeroVictorias())){
                throw new Exception("Las victorias tienen que ser positivas");
            }
            return mapDragon.mapearDragon(dragonRepository.save(dragon));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<DragonDTO> buscarTodosDragones() throws Exception{
        try {
            return mapDragon.mapearListaDragones(dragonRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public DragonDTO buscarDragonPorId(Integer id) throws Exception{
        try {
            Optional<Dragon> dragonOptional = dragonRepository.findById(id);
            if (dragonOptional.isPresent()){
                return mapDragon.mapearDragon(dragonOptional.get());
            }else {
                throw new Exception(MensajeServicios.DRAGON_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public DragonDTO editarDragon(Integer id,Dragon dragonNuevo) throws Exception{
        try {
            Optional<Dragon> dragonOptional = dragonRepository.findById(id);
            if (dragonOptional.isPresent()){
                Dragon dragon = dragonOptional.get();
                dragon.setNombreDragon(dragonNuevo.getNombreDragon());
                dragon.setAltura(dragonNuevo.getAltura());
                dragon.setEdad(dragonNuevo.getEdad());
                dragon.setNumeroVictorias(dragonNuevo.getNumeroVictorias());
                dragon.setJinete(dragonNuevo.getJinete());
                return mapDragon.mapearDragon(dragonRepository.save(dragon));
            }else {
                throw new Exception(MensajeServicios.DRAGON_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarDragon(Integer id) throws Exception{
        try {
            if (dragonRepository.existsById(id)){
                dragonRepository.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajeServicios.DRAGON_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
