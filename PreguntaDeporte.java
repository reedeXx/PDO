import java.util.List;

public class PreguntaDeporte extends Pregunta {

    private boolean verdaderoFalso;

    public PreguntaDeporte( String texto, int puntuacion ) {
    
        super(texto, puntuacion );

    }

    public PreguntaDeporte( String texto, int puntuacion ,boolean respuesta ) {
    
        super(texto, puntuacion );
        this.verdaderoFalso = respuesta;

    }

    public String ImprimeRespuesta(){

        String cadena = texto;
        return cadena;

    }

    public boolean verificarRespuesta( boolean respuesta  ) {        
        return ( respuesta == verdaderoFalso );
    }

    @Override
    public void mostrarRespuesta() {

        if ( verdaderoFalso )
            System.out.println("Verdadero");
        else
            System.out.println("Falso");

    
    }

    @Override
    public int getPuntuacion() {
        return puntuacionBase + 3;
    }

}
