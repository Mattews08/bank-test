import { Component } from '@angular/core';
import { PessoaService } from '../service/pessoa.service';
import { NgForm } from '@angular/forms';
import { Pessoa } from '../models/pessoa';

@Component({
  selector: 'app-cadastro-pessoa',
  templateUrl: './cadastro-pessoa.component.html',
  styleUrls: ['./cadastro-pessoa.component.css'],
})
export class CadastroPessoaComponent {
  pessoa: Pessoa = this.inicializarPessoa();

  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private pessoaService: PessoaService) {}

  private inicializarPessoa(): Pessoa {
    return {
      cpf: '',
      nome: '',
      idade: null,
      salario: null,
      localizacao: '',
    };
  }

  cadastrarPessoa(pessoaForm: NgForm) {
    this.pessoaService.cadastrarPessoa(this.pessoa).subscribe({
      next: () => {
        this.successMessage = 'Pessoa cadastrada com sucesso!';
        this.errorMessage = null;

        pessoaForm.resetForm();
        this.pessoa = this.inicializarPessoa();

        setTimeout(() => {
          this.successMessage = null;
        }, 3000);
      },
      error: (error) => {
        this.errorMessage = error.message;
        this.successMessage = null;

        setTimeout(() => {
          this.errorMessage = null;
        }, 3000);
      },
    });
  }
}
