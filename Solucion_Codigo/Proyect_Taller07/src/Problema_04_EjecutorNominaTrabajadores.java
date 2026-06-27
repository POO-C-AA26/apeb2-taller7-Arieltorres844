/*
problema04: Se desea desarrollar un sistema de nómina para los trabajadores de 
una empresa. Los datos personales de los trabajadores son nombre y apellidos, 
dirección y DNI. Además, existen diferentes tipos de trabajadores:

Fijos Mensuales: que cobran una cantidad fija al mes.
Comisionistas: cobran un porcentaje fijo por las ventas que han realizado
Por Horas: cobran un precio por cada una de las horas que han realizado durante 
el mes. El precio es fijo para las primeras 40 horas y es otro para las horas 
realizadas a partir de la 40 hora mensual.
Jefe: cobra un sueldo fijo (no hay que calcularlo). Cada empleado tiene 
obligatoriamente un jefe (exceptuando los jefes que no tienen ninguno). 
El programa debe permitir dar de alta a trabajadores, así como fijar horas o 
ventas realizadas e imprimir la nómina correspondiente al final de mes.
@autor Ariel Torres
@version 1.0
 */
class Trabajadores {

    protected String nombre, apellido, direccion, DNI;
    
    public Trabajadores(String nombre, String apellido, String direccion, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.DNI = DNI;
    }

    public double calcularSueldo() {
        return 0;
    }

    @Override
    public String toString() {
        return "Trabajadores{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", DNI=" + DNI + '}';
    }
}

class Trabajador_Mensual extends Trabajadores {

    private double SueldoFijo;

    public Trabajador_Mensual(double SueldoFijo, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.SueldoFijo = SueldoFijo;
    }

    @Override
    public double calcularSueldo() {
        return this.SueldoFijo;
    }

    @Override
    public String toString() {
        return "Trabajador_Mensual{" + "SueldoFijo=" + SueldoFijo + '}' + super.toString();
    }

}

class Trabajador_C extends Trabajadores {

    private double porcentaje;
    private double venta;
    private double sueldo;

    public Trabajador_C(double porcentaje, double venta, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.porcentaje = porcentaje;
        this.venta = venta;
    }

    @Override
    public double calcularSueldo() {
        this.sueldo = ((this.porcentaje / 100) * this.venta);
        return this.sueldo;
    }

    @Override
    public String toString() {
        return "Trabajador_C{" + "porcentaje=" + porcentaje + ", venta=" + venta + ", sueldo=" + sueldo + '}' + super.toString();
    }
}

class Trabajador_horas extends Trabajadores {

    private int horasTrabajadas;
    private double tarifaNormal;
    private double tarifaExtra;
    private double sueldo;

    public Trabajador_horas(double tarifaNormal, double tarifaExtra, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.tarifaNormal = tarifaNormal;
        this.tarifaExtra = tarifaExtra;
    }

    public void registrarHoras(int horas) {
        this.horasTrabajadas = horas;
    }

    @Override
    public double calcularSueldo() {
        if (horasTrabajadas <= 40) {
            this.sueldo = this.horasTrabajadas * this.tarifaNormal;
            return this.sueldo;
        }
        int extras = this.horasTrabajadas - 40;
        sueldo = (40 * this.tarifaNormal) + (extras * this.tarifaExtra);
        return this.sueldo;
    }

    @Override
    public String toString() {
        return "Trabajador_horas{" + "horasTrabajadas=" + horasTrabajadas
                + ", tarifaNormal=" + tarifaNormal + ", tarifaExtra=" + tarifaExtra + ", sueldo=" + sueldo + '}' + super.toString();
    }

}

class Jefe extends Trabajadores {

    private double sueldo;

    public Jefe(double sueldo, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.sueldo = sueldo;
    }

    @Override
    public double calcularSueldo() {
        return this.sueldo;
    }

    @Override
    public String toString() {
        return "Jefe{" + "sueldo=" + sueldo + '}' + super.toString();
    }
}

public class Problema_04_EjecutorNominaTrabajadores {

    public static void main(String[] args) {
        Jefe jefeGeneral = new Jefe(500.0, "Javier", "Calderon", "Quito", "1150487165");
        Trabajador_Mensual empleado1 = new Trabajador_Mensual(300.0, "Maria", "Torres",
                "Quito", "1102354865");
        Trabajador_C empleado2 = new Trabajador_C(10.0, 400.0, "Jose", "Soto",
                "Guayaquil", "1245789631");
        empleado2.calcularSueldo();
        Trabajador_horas empleado3 = new Trabajador_horas(10.0, 15.0, "Daniel", "Montes",
                "Quito", "1346798532");
        empleado3.registrarHoras(50);
        empleado3.calcularSueldo();
        System.out.println("--Nomina--");
        System.out.println(jefeGeneral);
        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3);
    }
}
/*
run:
--Nomina--
Jefe{sueldo=500.0}Trabajadores{nombre=Javier, apellido=Calderon, direccion=Quito, DNI=1150487165}
Trabajador_Mensual{SueldoFijo=300.0}Trabajadores{nombre=Maria, apellido=Torres, direccion=Quito, DNI=1102354865}
Trabajador_C{porcentaje=10.0, venta=400.0, sueldo=40.0}Trabajadores{nombre=Jose, apellido=Soto, direccion=Guayaquil, DNI=1245789631}
Trabajador_horas{horasTrabajadas=50, tarifaNormal=10.0, tarifaExtra=15.0, sueldo=550.0}Trabajadores{nombre=Daniel, apellido=Montes, direccion=Quito, DNI=1346798532}
 */
