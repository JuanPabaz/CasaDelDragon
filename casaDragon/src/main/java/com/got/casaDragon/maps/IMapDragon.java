package com.got.casaDragon.maps;

import com.got.casaDragon.DTO.DragonDTO;
import com.got.casaDragon.models.Dragon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapDragon {

    @Mappings({
            @Mapping(source = "nombreDragon",target = "nombreDragon"),
            @Mapping(source = "edad", target = "edad")
    })
    DragonDTO mapearDragon(Dragon dragon);

    @Mappings({
            @Mapping(source = "nombreDragon",target = "nombreDragon"),
            @Mapping(source = "edad", target = "edad")
    })
    List<DragonDTO> mapearListaDragones(List<Dragon> dragonList);

}
