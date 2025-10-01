package ar.com.practico1.trabajo.trabajo_01.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaCorriente extends Cuenta {
    private double montoGiroDesc;
    private List<Cheque> cheques = new ArrayList<>();

    public CuentaCorriente (int numero, Cliente clienteAsociado, double saldo, double montoGiroDesc){
        super(numero, clienteAsociado, saldo);
        this.montoGiroDesc = montoGiroDesc;
    }

    @Override
    public void extraer(double monto) {
        // Verifica si el monto a extraer no excede el saldo + el giro en descubierto
        if (monto <= getSaldo() + montoGiroDesc) {
            if (monto <= getSaldo()) {
                // Si el monto es menor o igual al saldo disponible, solo se reduce el saldo
                setSaldo(getSaldo() - monto);
            } else {
                // Si el monto excede el saldo, usar el giro en descubierto
                setSaldo(0);  // El saldo de la cuenta queda en 0
                montoGiroDesc -= (monto - getSaldo());  // Usamos el giro en descubierto
                System.out.println(montoGiroDesc);
            }
        } else {
            System.out.println("El monto a extraer excede el saldo disponible y el giro en descubierto.");
        }
    }
    
    public void depositarCheque(double monto, String bancoEmisor, LocalDate fechaPago) {
        Cheque cheque = new Cheque(monto, bancoEmisor, fechaPago);
        //depositar(cheque.getMonto()); DUDA SI INCLUIRLO O NO
        cheques.add(cheque);
        System.out.println("Cheque depositado con éxito. Monto: " + cheque.getMonto()
            + ", Banco Emisor: " + cheque.getBancoEmisor());
    }

    //Metodo para visualizar los cheques depositados
    public void mostrarChequesDepositados() {
        if (cheques.isEmpty()) {
            System.out.println("No hay cheques");
        } else {
            System.out.println("Cheques depositados: ");
            for (int i = 0; i < cheques.size(); i++) {
                Cheque c = cheques.get(i); // Obtiene el cheque en la posición i
                System.out.println("Monto: " + c.getMonto());
                System.out.println("Banco: " + c.getBancoEmisor());
                System.out.println("Fecha: " + c.getFechaPago());
            }
        }
    }
}
