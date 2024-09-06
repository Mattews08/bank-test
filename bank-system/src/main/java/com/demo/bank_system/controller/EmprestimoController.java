package com.demo.bank_system.controller;

import com.demo.bank_system.dto.EmprestimoRequest;
import com.demo.bank_system.dto.EmprestimoResponseDTO;
import com.demo.bank_system.dto.PessoaDTO;
import com.demo.bank_system.entity.Pessoa;
import com.demo.bank_system.service.EmprestimoService;
import com.demo.bank_system.service.PessoaService;
import com.demo.bank_system.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/analisar")
    public ResponseEntity<EmprestimoResponseDTO> analisarEmprestimo(@RequestBody EmprestimoRequest request) {
        PessoaDTO pessoaDTO = pessoaService.buscarPorCpf(request.getCpf());
        Pessoa pessoa = PessoaMapper.INSTANCE.toEntity(pessoaDTO);

        EmprestimoResponseDTO response = emprestimoService.analisarEmprestimo(pessoa, request.getValor());
        return ResponseEntity.ok(response);
    }
}
