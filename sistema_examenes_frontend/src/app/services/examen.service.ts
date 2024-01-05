import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ExamenService {

  constructor(private http:HttpClient) { }

  public listarCuestionarios(){
    return this.http.get(`${baseUrl}/examenes/`)
  }

  public agregarExamen(examen:any){
    return this.http.post(`${baseUrl}/examenes/`,examen)
  }

  public obtenerExamenId(examenId:any){
    return this.http.get(`${baseUrl}/examenes/${examenId}`)
  }

  public actualizarExamen(examen:any){
    return this.http.put(`${baseUrl}/examenes/`, examen)
  }

  public eliminarExamen(id:any){
    return this.http.delete(`${baseUrl}/examenes/${id}`)
  }
}
