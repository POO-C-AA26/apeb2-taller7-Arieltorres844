/*
problema01: Dibuje un diagrama de clases que muestre la estructura de un 
capítulo de libro; un capítulo está compuesto por varias secciones, cada una de 
las cuales comprende varios párrafos y figuras. Un párrafo incluye varias 
sentencias, cada una de las cuales contiene varias palabras.
Note
Suponga que en un futuro se prevé que el sistema gestione además de párrafos y 
figuras otros componentes, como tablas, listas, viñetas, etc.
Suponga además que una palabra puede aparecer en varias sentencias. 
@autor Ariel Torres
@version 1.0
 */
class Capitulo {

    private Seccion[] secciones;
}

class Seccion {

    private Componente[] componentes;
}

class Componente {
}

class Parrafo extends Componente {

    private Sentencia[] sentencias;
}

class Figura extends Componente {
}

class Tabla extends Componente {
}

class Lista extends Componente {
}

class Vineta extends Componente {
}

class Sentencia {

    private Palabra[] palabras;
}

class Palabra {

    private String texto;
}

public class Problema_01_EjecutorBiblioteca {

}
