public class PreguntaDeporteSki extends PreguntaDeporte{
    
    public PreguntaDeporteSki(String texto , int puntuacion) {
        super(texto , puntuacion );
    }

    @Override
    public int getPuntuacion() {
        puntuacionBase = super.getPuntuacion();
        return puntuacionBase * 2;
    }

}
