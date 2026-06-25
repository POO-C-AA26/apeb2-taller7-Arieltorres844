/*
problema05: Dadas las siguientes clases, que expresan una relación de herencia
entre las entidades:

Se desea gestionar la venta de entradas para un espectáculo en un teatro. 
El patio de butacas del teatro se divide en varias zonas, cada una identificada
por su nombre. Los datos de las zonas son los mostrados en la siguiente tabla:

NOMBRE ZONA	NÚMERO DE LOCALIDADES	PRECIO NORMA	PRECIO ABONADO
Principal	200	25$	17.5$
PalcoB	40	70$	40$
Central	400	20$	14$
Lateral	100	15.5$	10$

Para realizar la compra de una entrada, un espectador debe indicar la zona que
desea y presentar al vendedor el documento que justifique que tiene algún tipo 
de descuento (estudiante, abonado o pensionista). El vendedor sacará la entrada
del tipo apropiado y de la zona indicada, en el momento de la compra se asignará
a la entrada un identificador (un número entero) que permitirá la identificación
de la entrada en todas las operaciones que posteriormente se desee realizar con 
ella.

Una entrada tiene como datos asociados su identificador, la zona a la que 
pertenece y el nombre del comprador.

Los precios de las entradas dependen de la zona y del tipo de entrada según lo 
explicado a continuación:

Entradas normales: su precio es el precio normal de la zona elegida sin ningún 
tipo de descuento.
Entradas reducidas (para estudiantes o pensionistas): su precio tiene una rebaja
del 15% sobre el precio normal de la zona elegida.
Entradas abonado: su precio es el precio para abonados de la zona elegida.
*/
class Zona {

    public String nombreZona;
    public int cantidadesLocalidades;
    public double precioNormal;
    public double precioAbonado;

    public Zona(String nombreZona, int cantidadesLocalidades, double precioNormal, double precioAbonado) {
        this.nombreZona = nombreZona;
        this.cantidadesLocalidades = cantidadesLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    @Override
    public String toString() {
        return "Zona{" + "nombreZona=" + nombreZona + ", cantidadesLocalidades=" + cantidadesLocalidades + ", precioNormal=" + precioNormal + ", precioAbonado=" + precioAbonado + '}';
    }

}

class Entrada {

    public int idEntrada, numeroEntrada;
    public Zona zona;
    public String nombreComprado;
    public double costiFinalEntrada;

    public Entrada(int idEntrada, int numeroEntrada, Zona zona, String nombreComprado) {
        this.idEntrada = idEntrada;
        this.numeroEntrada = numeroEntrada;
        this.zona = zona;
        this.nombreComprado = nombreComprado;
    }

    public double calcularCostoFinalEntrada(double precioEntrada) {
        this.costiFinalEntrada = (this.numeroEntrada * precioEntrada);
        return this.costiFinalEntrada;
    }

    @Override
    public String toString() {
        return "Entrada{" + "idEntrada=" + idEntrada + ", numeroEntrada=" + numeroEntrada + ", zona=" + zona + ", nombreComprado=" + nombreComprado + ", costiFinalEntrada=" + costiFinalEntrada + '}';
    }

}

class Entrada_Normal extends Entrada {

    public Entrada_Normal(int idEntrada, int numeroEntrada, Zona zona, String nombreComprado) {
        super(idEntrada, numeroEntrada, zona, nombreComprado);
    }

    public double calcularCostoFinalEntrada() {
        this.costiFinalEntrada = (super.calcularCostoFinalEntrada(zona.precioNormal));
        return this.costiFinalEntrada;
    }

    @Override
    public String toString() {
        return "Entrada_Normal{" + '}' + super.toString();
    }

}

class Entrada_Reducida extends Entrada {

    public double porcentajeRebaja;

    public Entrada_Reducida(double porcentajeRebaja, int idEntrada, int numeroEntrada, Zona zona, String nombreComprado) {
        super(idEntrada, numeroEntrada, zona, nombreComprado);
        this.porcentajeRebaja = porcentajeRebaja;
    }

    public double calcularCostoFinalEntrada() {
        this.costiFinalEntrada = (super.calcularCostoFinalEntrada(zona.precioNormal - (zona.precioNormal * (porcentajeRebaja / 100))));
        return this.costiFinalEntrada;
    }

    @Override
    public String toString() {
        return "Entrada_Reducida{" + "porcentajeRebaja=" + porcentajeRebaja + '}' + super.toString();
    }

}

class Entrada_Abonada extends Entrada {

    public Entrada_Abonada(int idEntrada, int numeroEntrada, Zona zona, String nombreComprado) {
        super(idEntrada, numeroEntrada, zona, nombreComprado);
    }

    public double calcularCostoFinalEntrada() {
        this.costiFinalEntrada = (super.calcularCostoFinalEntrada(zona.precioAbonado));
        return this.costiFinalEntrada;
    }

    @Override
    public String toString() {
        return "Entrada_Abonada{" + '}' + super.toString();
    }

}

public class Problema_05_EjecutorTeatro {
    public static void main(String[] args) {
        Zona zona1 = new Zona("principal", 200, 25, 17.5);
        Zona zona2 = new Zona("palco", 40, 70, 40);
        Zona zona3 = new Zona("central", 400, 20, 14);
        Zona zona4 = new Zona("lateral", 100, 15, 10);
        Entrada_Normal entNormal = new Entrada_Normal(1, 1, zona4, "Jhonatan");
        Entrada_Reducida entReducida = new Entrada_Reducida(15, 2, 2, zona2, "Andre");
        Entrada_Abonada entAbonado = new Entrada_Abonada(3, 2, zona3, "Raul y Enrique");
        entNormal.calcularCostoFinalEntrada();
        entReducida.calcularCostoFinalEntrada();
        entAbonado.calcularCostoFinalEntrada();
        System.out.println(entNormal);
        System.out.println(entReducida);
        System.out.println(entAbonado);
    }
}
/*

*/
