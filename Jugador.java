import java.text.SimpleDateFormat;
import java.util.Date;

public class Jugador {

    private String nombre;
    private int puntuacion;
    private String FechaHora;

    public Jugador( String nombre ) {
        
        this.nombre = new String(nombre);
        Date fechaHoraActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        FechaHora = formato.format(fechaHoraActual);

    }

    public String getNombre() {
        return nombre;
    }

    public void atualizarPuntuacion(int puntuacion) {
        this.puntuacion += puntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String toString(){

        return "Data e hora: " + this.FechaHora + "\nNome do jogador: " + this.nombre;

    }

}
