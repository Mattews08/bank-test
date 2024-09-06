import { Component } from '@angular/core';
import { EmprestimoService } from '../service/emprestimo.service';

@Component({
  selector: 'app-listagem-emprestimos',
  templateUrl: './listagem-emprestimos.component.html',
  styleUrls: ['./listagem-emprestimos.component.css'],
})
export class ListagemEmprestimosComponent {
  emprestimo = {
    cpf: '',
    valor: 0,
  };

  emprestimosDisponiveis: string[] = [];
  errorMessage: string | null = null;
  mostrandoResultado: boolean = false;

  constructor(private emprestimoService: EmprestimoService) {}

  listarEmprestimos() {
    const { cpf, valor } = this.emprestimo;

    if (!cpf || !valor || valor <= 0) {
      this.errorMessage = 'CPF ou valor inválidos!';
      return;
    }

    this.emprestimoService.listarEmprestimos(cpf, valor).subscribe(
      (response) => {
        console.log(
          'Empréstimos disponíveis:',
          response.emprestimosDisponiveis
        );
        this.emprestimosDisponiveis = response.emprestimosDisponiveis;
        this.mostrandoResultado = true;
        this.errorMessage = null;
      },
      (error) => {
        console.error('Erro ao buscar empréstimos', error);
        this.errorMessage = error.error;
        this.mostrandoResultado = false;
      }
    );
  }

  novaPesquisa() {
    this.mostrandoResultado = false;
    this.emprestimo = {
      cpf: '',
      valor: 0,
    };
    this.emprestimosDisponiveis = [];
    this.errorMessage = null;
  }
}
