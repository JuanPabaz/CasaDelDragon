package com.got.casaDragon.maps;

import com.got.casaDragon.DTO.AliadoDTO;
import com.got.casaDragon.models.Aliado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapAliado {

    @Mappings({
            @Mapping(source = "nombreAliado",target = "nombreAliado"),
            @Mapping(source = "ubicacion", target = "ubicacion")
    })
    AliadoDTO mapearAliado(Aliado aliado);

    List<AliadoDTO> mapearListAliados(List<Aliado> aliadoList);

}
