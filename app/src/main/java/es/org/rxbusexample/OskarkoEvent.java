package es.org.rxbusexample;

/**
 * Clase POJO que actua como EVENTO que se pasará entre distintos
 * componentes (actividades, servicios, fragmentos) mediante un Bus de Eventos.
 * @autor Óscar Rodríguez <oscar.garrucho@gmail.com>
 * @since 19/3/16 13:39
 */
public class OskarkoEvent {

    private String text;

    public OskarkoEvent(){

    }

    public OskarkoEvent(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
