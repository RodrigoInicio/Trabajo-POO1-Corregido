package ar.com.practico1.trabajo.trabajo_01.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CajaAhorro extends Cuenta {
    private double tasaInteres;
    private double interes;// es el "monto" que resulto del calculo de los intereses que el cliente solicitó

    public CajaAhorro (int numero, Cliente clienteAsociado, double saldo, double tasaInteres){
        super(numero, clienteAsociado, saldo);
        this.tasaInteres = tasaInteres;
    }
    
    public void cobrarInteres(){
    this.interes = getSaldo() * tasaInteres / 100;
    }
}
