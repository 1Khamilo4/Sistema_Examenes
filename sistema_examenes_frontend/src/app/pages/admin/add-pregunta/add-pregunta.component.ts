import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { PreguntaService } from 'src/app/services/pregunta.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-pregunta',
  templateUrl: './add-pregunta.component.html',
  styleUrls: ['./add-pregunta.component.css']
})
export class AddPreguntaComponent implements OnInit{

  examenId:any;
  titulo:any;
  pregunta:any ={
    examen : {},
    contenido: "",
    pregunta1:"",
    pregunta2:"",
    pregunta3:"",
    pregunta4:"",
    respuesta:""

  };

  constructor(private route:ActivatedRoute, private preguntaService:PreguntaService, private snack:MatSnackBar){}

  ngOnInit(): void {
    this.examenId = this.route.snapshot.params["examenId"];
    this.titulo = this.route.snapshot.params['titulo']
    this.pregunta.examen['id'] = this.examenId;
  }

  formSubmit(){
    if(this.pregunta.contenido.trim() == '' || this.pregunta.contenido == null){
      return;
    }
    if(this.pregunta.pregunta1.trim() == '' || this.pregunta.pregunta1 == null){
      return;
    }
    if(this.pregunta.pregunta2.trim() == '' || this.pregunta.pregunta2 == null){
      return;
    }
    if(this.pregunta.pregunta3.trim() == '' || this.pregunta.pregunta3 == null){
      return;
    }
    if(this.pregunta.pregunta4.trim() == '' || this.pregunta.pregunta4 == null){
      return;
    }
    if(this.pregunta.respuesta.trim() == '' || this.pregunta.respuesta == null){
      return;
    }

    this.preguntaService.guardarPregunta(this.pregunta).subscribe(
      (res)=>{
        this.pregunta.contenido = "";
        this.pregunta.pregunta1 = "";
        this.pregunta.pregunta2 = "";
        this.pregunta.pregunta3 = "";
        this.pregunta.pregunta4 = "";
        this.pregunta.respuesta = "";

        Swal.fire(
          'Pregunta guardada',
          "La pregunta ha sido guardad con exito en la base de datos",
          "success"
        )
      },
      (err)=>{

        console.log(err);        
        Swal.fire(
          'Error',
          "Error al guardadr la pregunta en la base de datos",
          "error"
        )
      }
    )
    
  }

 

  
}
