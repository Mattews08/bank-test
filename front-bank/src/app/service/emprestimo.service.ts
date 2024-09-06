import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmprestimoService {
  private apiUrl = 'http://localhost:8080/emprestimo';

  constructor(private http: HttpClient) {}

  listarEmprestimos(cpf: string, valor: number): Observable<any> {
    // Envia CPF e valor no corpo da requisição POST
    return this.http.post(`${this.apiUrl}/analisar`, { cpf, valor });
  }
}
