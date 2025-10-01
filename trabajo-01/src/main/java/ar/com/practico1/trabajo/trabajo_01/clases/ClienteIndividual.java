package ar.com.practico1.trabajo.trabajo_01.clases;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true) //Llamado a la clase padre "Cliente"

public class ClienteIndividual extends Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    public ClienteIndividual (int numero, String nombre, String apellido, String dni){
        super(numero);//constructor de la clase padre "Cliente"
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    //Metodo simple para pruebas
    public void saludar(){
        System.out.println("Soy un Cliente Individual");
    }
}
