package com.got.casaDragon.service;

import com.got.casaDragon.models.Aliado;
import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.repositories.AliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AliadoService {

    @Autowired
    private AliadoRepository aliadoRepository;

    public Aliado guardarAliado(Aliado aliado) throws Exception{
        try {
            return aliadoRepository.save(aliado);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Aliado> buscarTodosAliados() throws Exception{
        try {
            return aliadoRepository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
