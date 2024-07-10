package com.got.casaDragon.service;

import com.got.casaDragon.models.Jinete;
import com.got.casaDragon.repositories.JineteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
