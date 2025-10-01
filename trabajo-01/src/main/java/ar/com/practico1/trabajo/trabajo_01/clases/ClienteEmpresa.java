package ar.com.practico1.trabajo.trabajo_01.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class ClienteEmpresa extends Cliente {
    private String nombreFantasia;
    private String cuit;

    public ClienteEmpresa (int numero, String nombreFantasia, String cuit){
        super(numero);//constructor de la clase padre "Cliente"
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }

    //Metodo simple para pruebas
    public void saludar(){
        System.out.println("Soy un Cliente Empresarial");
    }
}
