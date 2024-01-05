import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class PreguntaService {

  constructor(private http:HttpClient ) { }

  public listarPreguntasDelExamen(examenId:any){
    return this.http.get(`${baseUrl}/preguntas/examen/todos/${examenId}`)
  }

  public guardarPregunta(pregunta:any){
    return this.http.post(`${baseUrl}/preguntas/`, pregunta)
  }

  public eliminarPregunta(preguntaId:any){
    return this.http.delete(`${baseUrl}/preguntas/${preguntaId}`)
  }

  public actualizarPregunta(pregunta:any){
    return this.http.put(`${baseUrl}/preguntas/`, pregunta)
  }

  public obtenerPregunta(preguntaId:any){
    return this.http.get(`${baseUrl}/preguntas/${preguntaId}`)
  }
}
