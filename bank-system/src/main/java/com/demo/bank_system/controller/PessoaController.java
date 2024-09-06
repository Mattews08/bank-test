package com.demo.bank_system.controller;

import com.demo.bank_system.dto.PessoaDTO;
import com.demo.bank_system.service.PessoaService;
import com.demo.bank_system.exception.CpfAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO novaPessoa = pessoaService.cadastrarPessoa(pessoaDTO);
        return ResponseEntity.ok(novaPessoa);
    }

    @ExceptionHandler(CpfAlreadyExistsException.class)
    public ResponseEntity<String> handleCpfAlreadyExists(CpfAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
