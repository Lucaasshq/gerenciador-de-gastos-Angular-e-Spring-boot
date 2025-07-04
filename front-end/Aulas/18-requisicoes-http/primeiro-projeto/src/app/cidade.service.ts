import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Cidade } from './cidade';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {
  private apiUrl = 'http://localhost:3000/cidades';

  constructor(private http: HttpClient) {}

  consultar(): Observable<Cidade[]> {
   return this.http.get<Cidade[]>(this.apiUrl).pipe(
      catchError(err => {
        console.error('erro no service ao consultar cidade', err)
        return throwError(() => new Error("Erro ao consultar cidades"));
      })
   );
  }

  adicionar(cidade: Omit<Cidade, 'id'>): Observable<Cidade> {
   return this.http.post<Cidade>(this.apiUrl , cidade).pipe(
    catchError(err => {
      console.error('Erro ao adicionar cidade', err);
      return throwError(()=> new Error("Erro ao adicionar cidade"));
    })
   );
  }

  excluir(id: string): Observable<void> {
   return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
      catchError( err => {
        console.error("Erro ao excluir cidade", err);
        return throwError(() => new Error("Erro ao excluir cidade"));
      })
   )
  }

  atualizar(cidade: Cidade): Observable<Cidade> {
    return this.http.put<Cidade>(`${this.apiUrl}/${cidade.id}s`, cidade).pipe(
      catchError((err) => {
        console.error("Erro ao atualizar cidade", err);
        return throwError(() => new Error("Erro ao excluir cidade"))
      })
    )
  }
}
