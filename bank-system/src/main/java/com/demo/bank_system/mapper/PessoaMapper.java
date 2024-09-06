package com.demo.bank_system.mapper;

import com.demo.bank_system.dto.PessoaDTO;
import com.demo.bank_system.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO toDTO(Pessoa pessoa);
    Pessoa toEntity(PessoaDTO pessoaDTO);
}
