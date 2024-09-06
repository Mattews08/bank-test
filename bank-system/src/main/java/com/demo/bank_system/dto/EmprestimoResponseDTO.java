package com.demo.bank_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EmprestimoResponseDTO {
    private String nome;
    private List<String> emprestimosDisponiveis;
}
