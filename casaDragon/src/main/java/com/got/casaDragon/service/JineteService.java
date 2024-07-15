package com.got.casaDragon.service;

import com.got.casaDragon.DTO.JineteDTO;
import com.got.casaDragon.helpers.MensajeServicios;
import com.got.casaDragon.maps.IMapJinete;
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

    @Autowired
    private IMapJinete mapJinete;

    public JineteDTO guardarJinete(Jinete jinete) throws Exception{
        try {
            return mapJinete.mapearJinete(jineteRepository.save(jinete));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<JineteDTO> buscarTodosJinetes() throws Exception{
        try {
            return mapJinete.mepearListaJinetes(jineteRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public JineteDTO buscarJinetePorId(Integer id) throws Exception{
        try {
            Optional<Jinete> jineteOptional = jineteRepository.findById(id);
            if (jineteOptional.isPresent()){
                return mapJinete.mapearJinete(jineteOptional.get());
            }else {
                throw new Exception(MensajeServicios.JINETE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public JineteDTO editarJinete(Integer id,Jinete jineteNuevo) throws Exception{
        try {
            Optional<Jinete> jineteOptional = jineteRepository.findById(id);
            if (jineteOptional.isPresent()){
                Jinete jinete = jineteOptional.get();
                jinete.setEdadJinete(jinete.getEdadJinete());
                jinete.setFechaMontura(jinete.getFechaMontura());
                jinete.setNombreJinete(jinete.getNombreJinete());
                Integer idDragon = jineteNuevo.getDragones().get(0).getIdDragon();
                jinete.setDragones(jinete.getDragones());
                return mapJinete.mapearJinete(jineteRepository.save(jinete));
            }else {
                throw new Exception(MensajeServicios.JINETE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarJinete(Integer id) throws Exception{
        try {
            if (jineteRepository.existsById(id)){
                jineteRepository.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajeServicios.JINETE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
