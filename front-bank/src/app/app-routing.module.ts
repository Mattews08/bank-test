import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroPessoaComponent } from './cadastro-pessoa/cadastro-pessoa.component';
import { ListagemEmprestimosComponent } from './listagem-emprestimos/listagem-emprestimos.component';

const routes: Routes = [
  { path: 'cadastro-pessoa', component: CadastroPessoaComponent },
  { path: 'listagem-emprestimos', component: ListagemEmprestimosComponent },
  { path: '', redirectTo: '/cadastro-pessoa', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
