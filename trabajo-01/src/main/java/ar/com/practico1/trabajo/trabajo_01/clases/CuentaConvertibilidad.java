package ar.com.practico1.trabajo.trabajo_01.clases;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaConvertibilidad extends CuentaCorriente {
    private double saldoDolares;//Unico atributo
    
    public CuentaConvertibilidad (int numero, Cliente clienteEmpresa, double saldo, double montoGiroDesc){
        super(numero, clienteEmpresa, saldo, montoGiroDesc);
    }

    public void depositarCheque(double monto, String bancoEmisor, LocalDate fechaPago) {
        Cheque cheque = new Cheque(monto, bancoEmisor, fechaPago);
        getCheques().add(cheque);
        System.out.println("Cheque depositado con éxito. Monto: " + cheque.getMonto()
            + ", Banco Emisor: " + cheque.getBancoEmisor());
    }

    public void mostrarChequesDepositados() {
        if (getCheques().isEmpty()) {
            System.out.println("No hay cheques");
        } else {
            System.out.println("Cheques depositados: ");
            for (int i = 0; i < getCheques().size(); i++) {
                Cheque c = getCheques().get(i); // Obtiene el cheque en la posición i
                System.out.println("Monto: " + c.getMonto());
                System.out.println("Banco: " + c.getBancoEmisor());
                System.out.println("Fecha: " + c.getFechaPago());
            }
        }
    }

    //Medoto para convertir a dolares

    public void convertirADolares(double tipoCambio) {
        saldoDolares += getSaldo() / tipoCambio;
        setSaldo(0);
    }

    //Metodo para reconvertir a pesos Argentinos
    public void convertirDolaresAPesos(double tipoCambio) {
        double pesosYaConvertidos = saldoDolares * tipoCambio;// Convierte dólares a pesos
        setSaldo(getSaldo() + pesosYaConvertidos);// Agrega los pesos convertidos al saldo de la cuenta
        saldoDolares = 0;// Pone el saldo en dólares a 0 después de convertir
    }

    //Medoto depositar dolares

    public void depositarDolares(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo");
        } else {
            saldoDolares += monto;
        }
    }

    //Metodo depositar pesos
    public void depositarPesos(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo");
        } else {
            setSaldo(getSaldo() + monto);
        }
    }

    //Metodo extraer dolares

    public void extraerDolares(double monto) {
        if (saldoDolares - monto < 0) {
            System.out.println("El monto a extraer excede el saldo en dolares");
        } else {
            saldoDolares -= monto;
        }
    }

    //Metodo extraer pesos

    public void extraerPesos(double monto) {
        if (monto <= getSaldo()) {
            setSaldo(getSaldo() - monto);// Si el monto es menor o igual al saldo, se realiza la extracción
        }   else {
            System.out.println("Monto Excede el saldo. No se puede realizar la extraccion");
        }
    }
}
