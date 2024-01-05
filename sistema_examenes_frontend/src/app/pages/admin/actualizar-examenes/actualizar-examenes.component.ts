import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoriaService } from 'src/app/services/categoria.service';
import { ExamenService } from 'src/app/services/examen.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-actualizar-examenes',
  templateUrl: './actualizar-examenes.component.html',
  styleUrls: ['./actualizar-examenes.component.css']
})
export class ActualizarExamenesComponent implements OnInit{

  examenId = "";
  examen:any;
  categorias:any;

  constructor(private route:ActivatedRoute, private examenService:ExamenService, private categoriaService:CategoriaService, private router:Router  ){}

  ngOnInit(): void {
    this.examenId = this.route.snapshot.params["id"];
    this.examenService.obtenerExamenId(this.examenId).subscribe(
      (data:any)=>{
        this.examen = data;
        console.log(this.examen);
        
      },
      (err)=>{
        console.log(err);
        
      }
    );

    this.categoriaService.listarCategorias().subscribe(
      (data:any)=>{
        this.categorias = data;
      },
      (err)=>{
        alert("Error al cargar las categorias");
      }
    )
    
  }

  public actualizarDatos(){
    this.examenService.actualizarExamen(this.examen).subscribe(
      (data)=>{
        Swal.fire(
          'Examen actualizado',
          'El examen ha sido actualizado con exito',
          'success'
        ).then(
          (e)=>{
            this.router.navigate(["/admin/examenes"])
          }
        )
      },
      (err)=>{
        Swal.fire(
          'Error',
          'No se ha podido actualizar el examen',
          'error'
        )
      }
    )
  }

}
