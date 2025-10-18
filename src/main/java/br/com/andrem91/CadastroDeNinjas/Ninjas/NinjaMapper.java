package br.com.andrem91.CadastroDeNinjas.Ninjas;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NinjaMapper {
    NinjaModel toModel(NinjaDTO dto);
    NinjaDTO toDto(NinjaModel model);
}
