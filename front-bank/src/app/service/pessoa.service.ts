import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { Pessoa } from '../models/pessoa';

@Injectable({
  providedIn: 'root',
})
export class PessoaService {
  private apiUrl = 'http://localhost:8080/pessoa';

  constructor(private http: HttpClient) {}

  cadastrarPessoa(pessoa: Pessoa): Observable<Pessoa> {
    return this.http
      .post<Pessoa>(`${this.apiUrl}/cadastrar`, pessoa)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Ocorreu um erro inesperado.';

    if (error.error instanceof Array && error.status === 400) {
      errorMessage = error.error[0];
    } else if (typeof error.error === 'string') {
      errorMessage = error.error;
    }

    return throwError(() => new Error(errorMessage));
  }
}
