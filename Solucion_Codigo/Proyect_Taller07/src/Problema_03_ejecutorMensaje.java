/*
problema03:Implemente un sistema de envío de mensajes a móviles. Existen dos 
tipos de mensajes que se pueden enviar entre móviles, mensajes de texto (SMS) y 
mensajes que contienen imágenes (MMS). Por un lado, los mensajes de texto 
contienen un mensaje en caracteres que se desea enviar de un móvil a otro. Por 
otro lado, los mensajes que contienen imágenes almacenan información sobre la 
imagen a enviar, la cual se representará por el nombre del fichero que la 
contiene. Independientemente del tipo de mensaje, cada mensaje tendrá asociado 
un remitente de dicho mensaje y un destinatario. Ambos estarán definidos 
obligatoriamente por un número de móvil, y opcionalmente se podrá guardar 
información sobre su nombre. Además, los métodos enviarMensaje y 
visualizarMensaje deben estar definidos.
@autor Ariel Torres
@version 1.0
 */
class contacto {

    protected String numero;
    protected String nombre;

    public contacto(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "contacto{" + "numero=" + numero + ", nombre=" + nombre + '}';
    }
}

class Mensaje {

    protected contacto destinatario;
    protected contacto remitente;

    public Mensaje(contacto destinatario, contacto remitente) {
        this.destinatario = destinatario;
        this.remitente = remitente;
    }

    public String enviarMensaje() {
        return "enviando Mensaje";
    }

    public String mostrarMensaje() {
        return "mostrando Mensaje";
    }

    @Override
    public String toString() {
        return "Mensaje{" + "destinatario=" + destinatario + ", remitente=" + remitente + '}';
    }
}

class SMS extends Mensaje {

    private String mensajeTexto;

    public SMS(String mensajeTexto, contacto destinatario, contacto remitente) {
        super(destinatario, remitente);
        this.mensajeTexto = mensajeTexto;
    }

    @Override
    public String enviarMensaje() {
        return "enviando SMS A " + destinatario.nombre;
    }

    @Override
    public String mostrarMensaje() {
        return "texto:" + this.mensajeTexto;
    }

    @Override
    public String toString() {
        return "SMS{" + "mensajeTexto=" + mensajeTexto + '}' + super.toString();
    }
}

class MMS extends Mensaje {

    private String nombreImagen;

    public MMS(String nombreImagen, contacto destinatario, contacto remitente) {
        super(destinatario, remitente);
        this.nombreImagen = nombreImagen;
    }

    @Override
    public String enviarMensaje() {
        return "enviando MMS A " + destinatario.nombre;
    }

    @Override
    public String mostrarMensaje() {
        return "texto:" + this.nombreImagen;
    }

    @Override
    public String toString() {
        return "MMS{" + "nombreImagen=" + nombreImagen + '}' + super.toString();
    }
}

public class Problema_03_ejecutorMensaje {

    public static void main(String[] args) {
        contacto con1 = new contacto("123456789", "Juan");
        contacto con2 = new contacto("789456123", "Daniel");

        SMS sms = new SMS("hola amigo", con1, con2);
        MMS mms = new MMS("vacaciones.jpg", con2, con1);

        System.out.println(sms);
        System.out.println(mms);
    }
}
/*
run:
SMS{mensajeTexto=hola amigo}Mensaje{destinatario=contacto{numero=123456789, nombre=Juan}, remitente=contacto{numero=789456123, nombre=Daniel}}
MMS{nombreImagen=vacaciones.jpg}Mensaje{destinatario=contacto{numero=789456123, nombre=Daniel}, remitente=contacto{numero=123456789, nombre=Juan}}
 */
