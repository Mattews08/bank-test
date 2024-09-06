package com.demo.bank_system.service;

import com.demo.bank_system.dto.PessoaDTO;
import com.demo.bank_system.entity.Pessoa;
import com.demo.bank_system.exception.CpfAlreadyExistsException;
import com.demo.bank_system.exception.ResourceNotFoundException;
import com.demo.bank_system.mapper.PessoaMapper;
import com.demo.bank_system.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDTO) {
        if (pessoaRepository.existsByCpf(pessoaDTO.getCpf())) {
            throw new CpfAlreadyExistsException("CPF já cadastrado: " + pessoaDTO.getCpf());
        }

        Pessoa pessoa = PessoaMapper.INSTANCE.toEntity(pessoaDTO);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return PessoaMapper.INSTANCE.toDTO(pessoaSalva);
    }

    public PessoaDTO buscarPorCpf(String cpf) {
        Pessoa pessoa = pessoaRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa com CPF " + cpf + " não encontrada"));
        return PessoaMapper.INSTANCE.toDTO(pessoa);
    }
}
