import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemEmprestimosComponent } from './listagem-emprestimos.component';

describe('ListagemEmprestimosComponent', () => {
  let component: ListagemEmprestimosComponent;
  let fixture: ComponentFixture<ListagemEmprestimosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListagemEmprestimosComponent]
    });
    fixture = TestBed.createComponent(ListagemEmprestimosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
