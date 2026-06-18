
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

    public double costoAlquiler;
    public pelicula peliculas;

    public soporte(pelicula peliculas) {
        this.peliculas = peliculas;
    }

    public double calcularCostoAlquiler(int cantidadP, double precioAlquiler) {
        this.costoAlquiler = cantidadP * precioAlquiler;
        return this.costoAlquiler;
    }

    @Override
    public String toString() {
        return "soporte{" + "costoAlquiler=" + costoAlquiler + ", peliculas=" + peliculas + '}';
    }
}

class DVD extends soporte {

    public String idiomas[];
    public double recargo;

    public DVD(String[] idiomas, double recargo, pelicula peliculas) {
        super(peliculas);
        this.idiomas = idiomas;
        this.recargo = recargo;
    }

    public double calcularCostoAlquiler(int cantidadP, double precioAlquiler) {
        this.costoAlquiler = (super.calcularCostoAlquiler(cantidadP, precioAlquiler + (precioAlquiler * (this.recargo / 100))));
        return costoAlquiler;
    }

    @Override
    public String toString() {
        return "DVD{" + "idiomas=" + Arrays.toString(idiomas) + ", recargo=" + recargo + '}'+ super.toString();
    }

}

class VHS extends soporte {

    public String idioma;

    public VHS(String idioma, pelicula peliculas) {
        super(peliculas);
        this.idioma = idioma;
    }

    public double calcularCostoAlquiler(int cantidadP, double precioAlquiler) {
        this.costoAlquiler = cantidadP * precioAlquiler;
        return this.costoAlquiler;
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
        pelicula peli2 = new pelicula("La guerra", "jose", 2018);
        DVD peliMundial_Dvd = new DVD(idiomas, 10, peli1);
        VHS peliMundial_Vhs = new VHS("Es", peli1);
        VHS peliGuerra_Vhs = new VHS("Es", peli2);
        peliMundial_Dvd.calcularCostoAlquiler(2, 50);
        peliMundial_Vhs.calcularCostoAlquiler(2, 10);
        peliGuerra_Vhs.calcularCostoAlquiler(2, 10);
        System.out.println(peliMundial_Dvd);
        System.out.println(peliMundial_Vhs);
        System.out.println(peliGuerra_Vhs);
    }
}
/*
run:
DVD{idiomas=[ES, ENG], recargo=10.0}soporte{costoAlquiler=110.0, peliculas=pelicula{titulo=ElMundial, autor=Enrique, anio=2026}}
BUILD SUCCESSFUL (total time: 0 seconds)
 */
