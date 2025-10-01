package ar.com.practico1.trabajo.trabajo_01.tests;

import java.time.LocalDate;

import ar.com.practico1.trabajo.trabajo_01.clases.CajaAhorro;
import ar.com.practico1.trabajo.trabajo_01.clases.ClienteEmpresa;
import ar.com.practico1.trabajo.trabajo_01.clases.ClienteIndividual;
import ar.com.practico1.trabajo.trabajo_01.clases.CuentaConvertibilidad;
import ar.com.practico1.trabajo.trabajo_01.clases.CuentaCorriente;

public class TestSistemaBancario {
    public static void main(String[] args) {
        /*
         * CASO 1: UN CLIENTE (cliente1) TIENE UNA CAJA DE AHORRO Y UNA CUENTA CORRIENTE
         * EL cliente1 ES UN CLIENTE INDIVIDUAL
         */

        //CON CAJA DE AHORRO

        //Creo un cliente individual
        ClienteIndividual cliente1 = new ClienteIndividual(1, "Carlos", "Gil", "85671453");
        System.out.println(cliente1);//Veo el registro

        //Creo una cuenta del tipo Caja de Ahorro para el cliente1 (Carlos)
        CajaAhorro caja1 = new CajaAhorro(1, cliente1, 2000000, 10);
        System.out.println(caja1);//veo el registro

        //Vamos a depositar a nuestra caja de ahorro 1 millon mas
        caja1.depositar(1000000);//3000000
        System.out.println(caja1.getSaldo());//verifico si se depositó el monto ingresado
        System.out.println(caja1);//registro completo

        //Vamos a extraer 2 millones de nuestra caja de ahorro
        caja1.extraer(2000000);//1000000
        System.out.println(caja1.getSaldo());
        System.out.println(caja1);//registro completo

        //Intento forzar el "error" ingresando un monto a extraer superior al saldo que poseo
        caja1.extraer(2000000);//No se puede. Muestra el mensaje del metodo extraer de la clase padre Cuenta

        //Verifico por las dudas el saldo y el registro
        System.out.println(caja1.getSaldo());//1000000
        System.out.println(caja1);//registro completo

        /*
         * El cliente1 (Carlos) decide cobrar los intereses de su saldo actual que es 1 millon
         * La tasa de interes es del 10%
         */
        caja1.cobrarInteres();//Seria 100k
        System.out.println(caja1.getInteres());//100k

        //CON CUENTA CORRIENTE (cuentaC1)

        CuentaCorriente cuentaC1 = new CuentaCorriente(2, cliente1, 5000000, 2000000);
        System.out.println(cuentaC1);

        //Depositamos 1 millon
        cuentaC1.depositar(1000000);//6000000
        System.out.println(cuentaC1.getSaldo());//6000000
        System.out.println(cuentaC1);

        //Depositamos un cheque de 1 Millon
        cuentaC1.depositarCheque(1000000, "Galicia", LocalDate.now());

        //Vemos los cheques registrados y los visualizamos
        cuentaC1.mostrarChequesDepositados();

        //Extraemos 2 millones
        cuentaC1.extraer(2000000);//4000000
        System.out.println(cuentaC1.getSaldo());

        //Extraemos 5 millones
        cuentaC1.extraer(5000000);//Usara el cheque ingresado tambien
        System.out.println(cuentaC1.getSaldo());

        //Depositamos de nuevo 5 millones
        cuentaC1.depositar(5000000);//5000000
        System.out.println(cuentaC1.getSaldo());

        /*
         * CASO 2: cliente2 es un cliente de empresa y posee una Cuenta Corriente
         */
        
        //Creo un cliente de empresa
        ClienteEmpresa cliente2 = new ClienteEmpresa(2, "Hola S.R.L", "8-75967425-0");

        //Creo una cuenta corriente para la empresa
        CuentaCorriente cuentaC2 = new CuentaCorriente(3, cliente2, 90000000, 10000000);
        System.out.println(cuentaC2);

        //Deposito 10 millones
        cuentaC2.depositar(10000000);//100000000
        System.out.println(cuentaC2.getSaldo());
        System.out.println(cuentaC2);

        //Extraigo 20 millones
        cuentaC2.extraer(20000000);//80000000
        System.out.println(cuentaC2.getSaldo());
        System.out.println(cuentaC2);

        //Depositamos cheque de 1 millon
        cuentaC2.depositarCheque(1000000, "Banco Nacion", LocalDate.now());

        //Visualizamos el cheque
        cuentaC2.mostrarChequesDepositados();

        /*
         * CASO 3: cliente3 es una empresa que opera en pesos y en dolares
         */

        //Nueva empresa
        ClienteEmpresa cliente3 = new ClienteEmpresa(3, "Hello S.A", "8-96325841-0");
        System.out.println(cliente3);

        //Nueva cuenta corriente
        CuentaConvertibilidad cuentaCon1 = new CuentaConvertibilidad(4, cliente3, 100000, 500000);
        System.out.println(cuentaCon1);

        //Convierto a dolares
        cuentaCon1.convertirADolares(1000);//100 dolares
        System.out.println(cuentaCon1.getSaldoDolares());
        System.out.println(cuentaCon1);

        //Deposito 100 dolares
        cuentaCon1.depositarDolares(100);//200
        System.out.println(cuentaCon1.getSaldoDolares());
        System.out.println(cuentaCon1);

        //Extraigo 50 dolares
        cuentaCon1.extraerDolares(50);//150
        System.out.println(cuentaCon1.getSaldoDolares());
        System.out.println(cuentaCon1);

        //Reconvierto a pesos argentinos
        cuentaCon1.convertirDolaresAPesos(1000);//150000
        System.out.println(cuentaCon1.getSaldo());
        System.out.println(cuentaCon1);
    }
}
