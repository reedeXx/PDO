import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fichero {

    // Método para cargar preguntas desde un archivo de texto
    public static List<Pregunta> cargarPreguntasDesdeArchivo(String nombreArchivo) {
        List<Pregunta> listaPreguntas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Pregunta pregunta = parsearLineaAPregunta(linea);
                if ( pregunta != null )
                    listaPreguntas.add(pregunta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPreguntas;
    }

/*
    // Método para guardar el estado del juego en un archivo de objetos
    public static void guardarEstadoJuego(String nombreArchivo, InformacionJuego informacionJuego) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(informacionJuego);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

/* Método para cargar el estado del juego desde un archivo de objetos
    public static InformacionJuego cargarEstadoJuego(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (InformacionJuego) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
*/
    
    /* Método privado para convertir una línea en una pregunta private static Pregunta parsearLineaAPregunta(String linea) {
        String[] partes = linea.split(";");
        if (partes.length == 2) {
            String textoPregunta = partes[0].trim();
            String respuesta = partes[1].trim();
            Pregunta pregunta = new Pregunta(textoPregunta, 5);
            pregunta.
            return pregunta;
        } else {
            // Si la línea no tiene el formato esperado, puedes manejarlo de alguna manera
            System.out.println("Formato de línea no válido: " + linea);
            return null;
        }
    }*/


    private static String obtenerIniciales( String nombreCompleto ){

        StringBuilder iniciales = new StringBuilder();

        if (nombreCompleto != null && !nombreCompleto.isEmpty()) {
            String[] partesNombre = nombreCompleto.split("\\s+"); // Dividir por espacios en blanco

            for (String parte : partesNombre) {
                if (!parte.isEmpty()) {
                    iniciales.append(parte.charAt(0));
                }
            }
        }

        return iniciales.toString().toUpperCase();        

    }

    public static void guardarEstadoJuego(Jugador j ) {
        String nombreArchivo = "pootrivia_jogo_" + j.getFecha() + "_" +  obtenerIniciales( j.getNombre() ) + ".dat";
 // Deserialización de varios objetos
        try (ObjectOutputStream salida  = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {

            salida.writeObject(j.getFecha());
            salida.writeObject(j.getNombre());
            salida.writeObject(j.getPreguntasAcertadas());     
        

            System.out.println("Objetos serializados correctamente.");
                      
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jugador cargarJugador(String nombrearchivp){

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("personas.dat"))) {

            String f = (String) entrada.readObject();
            String n = (String) entrada.readObject();
            List <Pregunta> pA = (List <Pregunta>) entrada.readObject();
              
            Jugador jdes = new Jugador( n , f , pA );

            return jdes;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    private static Pregunta parsearLineaAPregunta(String linea) {
        String[] partesPrincipales = linea.split(";", 2);

        if (partesPrincipales.length == 2) {
            String texto = partesPrincipales[0].trim();
            String respuesta = partesPrincipales[1].trim();

            String[] partesRespuesta = respuesta.split(";");
            if (partesRespuesta.length >= 1) {

                List<String> opciones = Arrays.asList(Arrays.copyOfRange(partesRespuesta, 0, partesRespuesta.length ));
                if (linea.contains("::A::")) {
                    texto = texto.replace("::A::", "");
                    return new PreguntaArtes(texto, 5, opciones, opciones.get(0), "Artes");
                } else if (linea.contains("::C::")) {
                    texto = texto.replace("::C::", "");
                    return new PreguntaCiencia(texto, 5, opciones, opciones.get(0), "Ciencia");
                } else if (linea.contains("::F::")) {
                    texto = texto.replace("::F::", "");
                    return new PreguntaDeporteFutbol(texto, 5, opciones, opciones.get(0), "Futbol");
                } else if (linea.contains("::N::")) {
                    texto = texto.replace("::N::", "");
                    return new PreguntaDeporteNatacion(texto, 5, opciones, opciones.get(0), "Natacion");
                } else if (linea.contains("::S::")) {
                    texto = texto.replace("::S::", "");
                    return new PreguntaDeporteSki(texto, 5, opciones, opciones.get(0), "Ski");
                } else {
                    System.out.println("Categoría de pregunta desconocida: " + linea);
                    return null;
                }
            } else {
                return null;
            }
        } else {
          
            return null;
}
    }
}
