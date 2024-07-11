package com.got.casaDragon.service;

import com.got.casaDragon.helpers.MensajeServicios;
import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.models.Jinete;
import com.got.casaDragon.repositories.JineteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JineteService {

    @Autowired
    private JineteRepository jineteRepository;

    public Jinete guardarJinete(Jinete jinete) throws Exception{
        try {
            return jineteRepository.save(jinete);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Jinete> buscarTodosJinetes() throws Exception{
        try {
            return jineteRepository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Jinete buscarJinetePorId(Integer id) throws Exception{
        try {
            Optional<Jinete> jineteOptional = jineteRepository.findById(id);
            if (jineteOptional.isPresent()){
                return jineteOptional.get();
            }else {
                throw new Exception(MensajeServicios.JINETE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
