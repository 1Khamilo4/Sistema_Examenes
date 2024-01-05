package com.sistema.examenes.exceptions;

    public class UsuarioNotFoundException extends Exception{

        public  UsuarioNotFoundException(){
            super("El Usuario con ese username no existe en la base de datos, vuelva a intentar");
        }

        public UsuarioNotFoundException(String mensaje){
            super(mensaje);
        }
    }
