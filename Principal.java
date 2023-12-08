import java.util.List;
public class Principal {
    public static void main(String[] args) {
        /*
        Jugador j = new Jugador("pepe");
        System.out.println(j.toString());
        PreguntaDeporteSki p1 = new PreguntaDeporteSki("ejemplo", 5);
        System.out.println(p1.getPuntuacion());
        */
    
        List <Pregunta> ejemplo = Fichero.cargarPreguntasDesdeArchivo("preguntas.txt");

        for( int i=0 ; i<ejemplo.size() ; i++ ){
           System.out.println(ejemplo.get(i).getTexto());
           ejemplo.get(i).mostrarRespuesta();
        }
        

    
    }

}
