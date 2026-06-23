
import java.util.Arrays;

/*
problema02: Un videoclub dispone de una serie de películas que pueden estar en 
DVD (con capacidad en Gb.) o en VHS (una sola cinta por película y con cierto 
tipo de cinta magnetica). De las películas interesa guardar el título, el autor,
el año de edición y el idioma (o los idiomas, en caso de DVD). El precio de 
alquiler de las películas varía en función del tipo de película. Las DVD siempre
son 10% mas caras que las de VHS.
@autor Ariel Torres
@version 1.0
 */
class pelicula {

    public String titulo;
    public String autor;
    public int anio;

    public pelicula(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + '}';
    }

}

class soporte {

    public double costoAlquiler, precio;
    public pelicula peliculas;
    public int cantidad;

    public soporte(double precio, pelicula peliculas, int cantidad) {
        this.precio = precio;
        this.peliculas = peliculas;
        this.cantidad = cantidad;
    }

    public double calcularCostoAlquiler() {
        this.costoAlquiler = (this.cantidad * this.precio);
        return this.costoAlquiler;
    }

    @Override
    public String toString() {
        return "soporte{" + "costoAlquiler=" + costoAlquiler + ", peliculas=" + peliculas + '}';
    }
}

class DVD extends soporte {

    public String idiomas[];
    public double porcentajeRecargo;

    public DVD(String[] idiomas, double porcentajeRecargo, double precio, pelicula peliculas, int cantidad) {
        super(precio, peliculas, cantidad);
        this.idiomas = idiomas;
        this.porcentajeRecargo = porcentajeRecargo;
    }

    public double calcularCostoAlquiler() {
        this.costoAlquiler = super.calcularCostoAlquiler() + (this.costoAlquiler * (this.porcentajeRecargo / 100));
        return costoAlquiler;
    }

    @Override
    public String toString() {
        return "DVD{" + "idiomas=" + Arrays.toString(idiomas) + ", porcentajeRecargo=" + porcentajeRecargo + '}' + super.toString();
    }

}

class VHS extends soporte {

    public String idioma;

    public VHS(String idioma, double precio, pelicula peliculas, int cantidad) {
        super(precio, peliculas, cantidad);
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "VHS{" + "idioma=" + idioma + '}' + super.toString();
    }

}

public class Problema_02_EjecutarVideoClub {

    public static void main(String[] args) {
        String idiomas[] = {"ES", "ENG"};
        pelicula peli1 = new pelicula("ElMundial", "Enrique", 2026);
        DVD peliMundial_Dvd = new DVD(idiomas, 10, 10, peli1, 2);
        peliMundial_Dvd.calcularCostoAlquiler();
        VHS peVhs = new VHS(idiomas[0], 10, peli1, 2);
        peVhs.calcularCostoAlquiler();
        System.out.println(peliMundial_Dvd);
        System.out.println(peVhs);
    }
}
/*
run:
DVD{idiomas=[ES, ENG], porcentajeRecargo=10.0}soporte{costoAlquiler=22.0, peliculas=pelicula{titulo=ElMundial, autor=Enrique, anio=2026}}
VHS{idioma=ES}soporte{costoAlquiler=20.0, peliculas=pelicula{titulo=ElMundial, autor=Enrique, anio=2026}}
BUILD SUCCESSFUL (total time: 0 seconds)
 */
