import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jugador implements Serializable{

    private String nombre;
    private int puntuacion=0;
    private String FechaHora;
    private List <Pregunta> preguntasAcertadas;

    public Jugador( String nombre ) {
        
        this.preguntasAcertadas = new ArrayList<>();
        this.nombre = new String(nombre);
        Date fechaHoraActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        FechaHora = formato.format(fechaHoraActual);

    }

    public Jugador( String nombre , String fecha , List<Pregunta> pa ){

        this.preguntasAcertadas = pa;
        this.nombre = nombre;
        this.FechaHora = fecha;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String n ) {
        this.nombre = n;
    }

    public List <Pregunta> getPreguntasAcertadas(){

        return this.preguntasAcertadas;

    }

    public void setPreguntasAcertadas( Pregunta p ){

        this.preguntasAcertadas.add(p);

    }


    public void atualizarPuntuacion() {
        
        int p=0;
        for (  int i=0 ; i < preguntasAcertadas.size() ; i++ ){

            p += preguntasAcertadas.get(i).getPuntuacion();

        }

        this.puntuacion = p;

    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getFecha(){

        return FechaHora;

    }
    
    public void setFecha( String f ) {
        this.FechaHora= f;
    }

    
    public String toString(){

        String cadena = "Data e hora: " + this.FechaHora + "\nNome do jogador: " + this.nombre;

        for (  int i=0 ; i< this.preguntasAcertadas.size() ; i++ ){

            cadena += preguntasAcertadas.get(i).getTexto();

        }
    
        return cadena;

    }

}
