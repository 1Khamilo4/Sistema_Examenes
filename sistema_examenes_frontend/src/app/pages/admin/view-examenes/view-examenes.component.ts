import { Component, OnInit } from '@angular/core';
import { ExamenService } from 'src/app/services/examen.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-examenes',
  templateUrl: './view-examenes.component.html',
  styleUrls: ['./view-examenes.component.css']
})
export class ViewExamenesComponent implements OnInit{

  examenes : any=[]

  constructor( private examenService:ExamenService ){}

  ngOnInit(): void {
    this.examenService.listarCuestionarios().subscribe(
      (data:any)=>{
        this.examenes = data;

        console.log(this.examenes);
        
      },
      (err)=>{
        console.log(err);
        Swal.fire(
          "Error",
          "Error al cargar los examenes",
          "error"
        )
        
      }
    );
  }

  eliminarExamen(id:any){
      Swal.fire({
        title:"Eliminar examen",
        text:"¿Estas segruo de eliminar el examen?",
        icon:"warning",
        showCancelButton:true,
        confirmButtonColor:"#3085d6",
        cancelButtonColor:"#d33",
        confirmButtonText:"Eliminar",
        cancelButtonText:"Cancel"
      }).then((result)=>{

        if(result.isConfirmed){
          this.examenService.eliminarExamen(id).subscribe(
            (data)=>{
              console.log(data);
              this.examenes = this.examenes.filter((examen:any)=> examen.id != id);
              Swal.fire(
                "Se elimino",
                "Se ha eliminado el examen",
                'success'
              )
            },
            (err)=>{
              console.log(err);
              
              Swal.fire(
                "Error",
                "Error al eliminar el examen",
                'error'
              )
            }
          )
        }

      })
  }



}
