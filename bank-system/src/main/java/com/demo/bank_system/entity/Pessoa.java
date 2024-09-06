package com.demo.bank_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Pessoa {

    @Id
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos")
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Min(value = 18, message = "Idade mínima é 18 anos")
    private int idade;

    @Min(value = 0, message = "Salário deve ser maior ou igual a zero")
    private double salario;

    @NotBlank(message = "Localização é obrigatória")
    private String localizacao;
}
