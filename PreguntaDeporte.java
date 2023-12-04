import java.util.List;

public class PreguntaDeporte extends Pregunta {

    private boolean verdaderoFalso;

    public PreguntaDeporte( String texto, int puntuacion ) {
    
        super(texto, puntuacion );

    }

    public String ImprimeRespuesta(){

        String cadena = texto;
        return cadena;

    }

    public boolean verificarRespuesta( boolean respuesta  ) {        
        return ( respuesta == verdaderoFalso );
    }

    @Override
    public int getPuntuacion() {
        return puntuacionBase + 3;
    }

}
