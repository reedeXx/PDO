public class PreguntaDeporteNatacion extends Pregunta{
        public PreguntaDeporteNatacion(String texto , int puntuacion) {
            super(texto , puntuacion );
        }

        @Override
        public int getPuntuacion() {
            puntuacionBase = super.getPuntuacion();
            return puntuacionBase + 10;
        }

    }

