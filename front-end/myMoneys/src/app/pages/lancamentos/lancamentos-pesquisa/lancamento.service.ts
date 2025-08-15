import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { LancamentoFiltro } from '../../../Model/LancamentoFiltro';

@Injectable({
  providedIn: 'root'
})
export class LancamentoService {

  lancamentosUrl = "http://localhost:8080/lancamentos";




  constructor(private http: HttpClient) { }

  pesquisar(filtro:LancamentoFiltro): Observable<any> {
    let params = new HttpParams();

    if (filtro.descricao) {
    params =  params.set("descricao", filtro.descricao)
    }

    return this.http.get(`${this.lancamentosUrl}/resumo`, {params}).pipe(
      catchError(err => {
        console.error("erro ao consultar lancamentos", err);
        return throwError(() => new Error("erro ao consultar lancamentos"));
      })
    );
  }
}
