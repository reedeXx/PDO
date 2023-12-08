public class PreguntaDeporteNatacion extends PreguntaDeporte{
        public PreguntaDeporteNatacion(String texto , int puntuacion) {
            super(texto , puntuacion );
        }

        public PreguntaDeporteNatacion( String texto, int puntuacion ,boolean respuesta ){

            super(texto, puntuacion, respuesta);    

        }

        @Override
        public void mostrarRespuesta() {
            
            super.mostrarRespuesta();
    
        }
        
        @Override
        public int getPuntuacion() {
            puntuacionBase = super.getPuntuacion();
            return puntuacionBase + 10;
        }

}

