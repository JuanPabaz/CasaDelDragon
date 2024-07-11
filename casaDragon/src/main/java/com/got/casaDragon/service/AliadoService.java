package com.got.casaDragon.service;

import com.got.casaDragon.helpers.MensajeServicios;
import com.got.casaDragon.models.Aliado;
import com.got.casaDragon.models.Dragon;
import com.got.casaDragon.models.Jinete;
import com.got.casaDragon.repositories.AliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Aliado buscarAliadoPorId(Integer id) throws Exception{
        try {
            Optional<Aliado> aliadoOptional = aliadoRepository.findById(id);
            if (aliadoOptional.isPresent()){
                return aliadoOptional.get();
            }else {
                throw new Exception(MensajeServicios.ALIADO_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
