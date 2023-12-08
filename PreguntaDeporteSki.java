public class PreguntaDeporteSki extends PreguntaDeporte{
    
    public PreguntaDeporteSki(String texto , int puntuacion) {
        super(texto , puntuacion );
    }
    
    public PreguntaDeporteSki( String texto, int puntuacion ,boolean respuesta ){

        super(texto, puntuacion, respuesta);    

    }

    @Override
    public void mostrarRespuesta() {
        
        super.mostrarRespuesta();

    }
   
    @Override
    public int getPuntuacion() {
        puntuacionBase = super.getPuntuacion();
        return puntuacionBase * 2;
    }

}
