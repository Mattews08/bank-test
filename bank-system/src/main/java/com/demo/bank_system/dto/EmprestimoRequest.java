package com.demo.bank_system.dto;

import lombok.Data;

@Data
public class EmprestimoRequest {
    private String cpf;
    private Double valor;
}
