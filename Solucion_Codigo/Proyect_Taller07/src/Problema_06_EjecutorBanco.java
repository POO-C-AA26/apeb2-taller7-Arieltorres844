/*
problema06:El banco UN BANCO mantiene las cuentas de varios clientes. 
Los datos que describen a cada una de las cuentas consisten en el número de 
cuenta, el nombre del cliente y el balance actual. Escriba una clase para 
implementar dicha cuenta bancaria. El método constructor debe aceptar como 
parámetros el número de cuenta y el nombre. Debe proporcionarse métodos para 
depositar o retirar una cantidad de dinero y obtener el balance actual.
El banco ofrece a sus clientes dos tipos de cuentas, una de CHEQUES y una de 
AHORROS. Una cuenta de cheques puede sobregirarse (el balance puede ser menor 
que cero), pero una cuenta de ahorros no. Al final de cada mes, se calcula el 
interés sobre la cantidad que tenga la cuenta de ahorros. Este interés se suma
al balance. Escriba clases para describir cada uno de estos tipos de cuentas, 
haciendo un máximo uso de la herencia. La clase de la cuenta de ahorros debe 
proporcionar un método que sea invocado para calcular el interés. Además, el 
banco está pensando en implementar una cuenta PLATINO que viene siendo similar 
a los otros dos tipos anteriores de cuentas bancarias, ésta tiene el interés 
del 10%, sin cargos ni castigos por sobregiro. 
@autor Ariel Torres
@version 1.0
*/
class Cuenta {

    protected String numeroCuenta;
    protected String nombreCliente;
    protected double balance;

    public Cuenta(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0;
    }

    public void depositar(double cantidad) {
        this.balance += cantidad;
    }

    public void retirar(double cantidad) {
        this.balance -= cantidad;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombreCliente
                + ", Cuenta: " + numeroCuenta
                + ", Balance: $" + balance;
    }
}

class CuentaCheques extends Cuenta {

    public CuentaCheques(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public String toString() {
        return "CuentaCheques{" + '}' + super.toString();
    }

}

class CuentaAhorros extends Cuenta {

    protected double tasaInteres;

    public CuentaAhorros(String numeroCuenta, String nombreCliente, double tasaInteres) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= this.balance) {
            this.balance -= cantidad;
        }
    }

    public void calcularInteres() {
        this.balance += this.balance * this.tasaInteres;
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" + "tasaInteres=" + tasaInteres + '}' + super.toString();
    }

}

class CuentaPlatino extends CuentaAhorros {

    public CuentaPlatino(String numeroCuenta,String nombreCliente) {
        super(numeroCuenta, nombreCliente, 0.10);
    }

    @Override
    public String toString() {
        return "CuentaPlatino{" + '}' + super.toString();
    }

}

public class Problema_06_EjecutorBanco {

    public static void main(String[] args) {

        CuentaCheques cuenta1 = new CuentaCheques("001", "Maria Torres");
        CuentaAhorros cuenta2 = new CuentaAhorros("002", "Jose Soto", 0.05);
        CuentaPlatino cuenta3 = new CuentaPlatino("003", "Daniel Montes");
        cuenta1.depositar(500);
        cuenta1.retirar(700);
        cuenta2.depositar(1000);
        cuenta2.retirar(300);
        cuenta2.calcularInteres();
        cuenta3.depositar(2000);
        cuenta3.calcularInteres();
        System.out.println("===== ESTADO DE CUENTAS =====");
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
    }
}
/*
run:
===== ESTADO DE CUENTAS =====
CuentaCheques{}Cliente: Maria Torres, Cuenta: 001, Balance: $-200.0
CuentaAhorros{tasaInteres=0.05}Cliente: Jose Soto, Cuenta: 002, Balance: $735.0
CuentaPlatino{}CuentaAhorros{tasaInteres=0.1}Cliente: Daniel Montes, Cuenta: 003, Balance: $2200.0
*/
