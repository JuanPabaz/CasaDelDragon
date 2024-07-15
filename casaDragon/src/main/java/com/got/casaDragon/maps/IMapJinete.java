package com.got.casaDragon.maps;

import com.got.casaDragon.DTO.JineteDTO;
import com.got.casaDragon.models.Jinete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IMapJinete {

    @Mappings({
            @Mapping(source = "nombreJinete",target = "nombreJinete"),
            @Mapping(source = "edadJinete", target = "edadJinete")
    })
    JineteDTO mapearJinete(Jinete jinete);

}
