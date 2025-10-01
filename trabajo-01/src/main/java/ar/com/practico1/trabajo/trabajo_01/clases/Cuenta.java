package ar.com.practico1.trabajo.trabajo_01.clases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Cuenta {
    private int numero;
    private Cliente clienteAsociado;
    private double saldo;

    public void depositar(double monto){
        if (monto <= 0) {
            System.out.println("El saldo debe ser positivo");
        } else {
            this.saldo += monto;
        }
    }

    public void extraer(double monto){
        if (saldo - monto < 0) {
            System.out.println("El monto a extraer excede el saldo de tu cuenta");
        } else {
            this.saldo -= monto;
        }
    }
}
