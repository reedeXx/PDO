import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        String ruta = System.getProperty("user.dir");
        List<Pregunta> preguntas = Fichero.cargarPreguntasDesdeArchivo("C:\\Users\\pauli\\OneDrive\\Escritorio\\Coimbra\\Programacion\\preguntas.txt");
        int ronda =0;


       /* for (String opcion : opciones) {
            System.out.println(opcion);*/ //IMPRIMIR OPCIONES AL MEZCLAR
        Interfaz panel=new Interfaz();

            Random random = new Random();

        boolean[] preguntasSeleccionadas = new boolean[preguntas.size()];


             int indiceAleatorio = random.nextInt(preguntas.size());

            if (!preguntasSeleccionadas[indiceAleatorio]) {

                Pregunta pregunta = preguntas.get(indiceAleatorio);
                preguntasSeleccionadas[indiceAleatorio] = true;


                panel.crearVentana( pregunta);

        }
    }
        }
