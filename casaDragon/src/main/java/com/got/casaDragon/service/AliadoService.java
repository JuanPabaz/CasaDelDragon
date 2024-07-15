package com.got.casaDragon.service;

import com.got.casaDragon.DTO.AliadoDTO;
import com.got.casaDragon.helpers.MensajeServicios;
import com.got.casaDragon.maps.IMapAliado;
import com.got.casaDragon.models.Aliado;
import com.got.casaDragon.repositories.AliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AliadoService {

    @Autowired
    private AliadoRepository aliadoRepository;

    @Autowired
    private IMapAliado mapAliado;

    public AliadoDTO guardarAliado(Aliado aliado) throws Exception{
        try {
            return mapAliado.mapearAliado(aliadoRepository.save(aliado));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<AliadoDTO> buscarTodosAliados() throws Exception{
        try {
            return mapAliado.mapearListAliados(aliadoRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public AliadoDTO buscarAliadoPorId(Integer id) throws Exception{
        try {
            Optional<Aliado> aliadoOptional = aliadoRepository.findById(id);
            if (aliadoOptional.isPresent()){
                return mapAliado.mapearAliado(aliadoOptional.get());
            }else {
                throw new Exception(MensajeServicios.ALIADO_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public AliadoDTO editarAliado(Integer id,Aliado aliadoNuevo) throws Exception{
        try {
            Optional<Aliado> aliadoOptional = aliadoRepository.findById(id);
            if (aliadoOptional.isPresent()){
                Aliado aliado = aliadoOptional.get();
                aliado.setNombreAliado(aliado.getNombreAliado());
                aliado.setAporte(aliado.getAporte());
                aliado.setUbicacion(aliado.getUbicacion());
                return mapAliado.mapearAliado(aliadoRepository.save(aliado));
            }else {
                throw new Exception(MensajeServicios.ALIADO_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarAliado(Integer id) throws Exception{
        try {
            if (aliadoRepository.existsById(id)){
                aliadoRepository.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajeServicios.ALIADO_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }




}
