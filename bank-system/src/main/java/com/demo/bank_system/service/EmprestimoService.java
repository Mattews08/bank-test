package com.demo.bank_system.service;

import com.demo.bank_system.dto.EmprestimoResponseDTO;
import com.demo.bank_system.entity.Pessoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

    public EmprestimoResponseDTO analisarEmprestimo(Pessoa pessoa, Double valorEmprestimo) {
        List<String> emprestimos = new ArrayList<>();
        String localizacao = pessoa.getLocalizacao();
        double salario = pessoa.getSalario();
        int idade = pessoa.getIdade();

        if (salario <= 3000) {
            emprestimos.add("Empréstimo Pessoal (Taxa: 4%)");
            emprestimos.add("Empréstimo com Garantia (Taxa: 3%)");
        }

        if (salario >= 5000) {
            emprestimos.add("Empréstimo Consignado (Taxa: 2%)");
        }

        if (salario > 3000 && salario <= 5000 && idade < 30 && "São Paulo".equals(localizacao)) {
            emprestimos.add("Empréstimo Pessoal (Taxa: 4%)");
            emprestimos.add("Empréstimo com Garantia (Taxa: 3%)");
        }

        return new EmprestimoResponseDTO(pessoa.getNome(), emprestimos);
    }
}
