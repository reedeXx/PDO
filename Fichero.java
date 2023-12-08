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

    private static Pregunta parsearLineaAPregunta(String linea) {
        String[] partes = linea.split(";");
        if (partes.length >= 2) {
            String texto = partes[0].trim();
            String respuesta = partes[1].trim();
            
            
            if (linea.contains("::A::")) {
                String[] textoRespuesta = texto.split("::A::"); 
                List<String> opciones = Arrays.asList(Arrays.copyOfRange(partes, 1, partes.length));     
                int inicio = Math.max(0, opciones.size() - 3);
                int fin = opciones.size();                                        
                return new PreguntaArtes(textoRespuesta[1],  5, partes[partes.length - 1] , opciones, opciones.subList(inicio, fin) );   
            } else if (linea.contains("::C::")) {
                String[] textoRespuesta = texto.split("::C::");           
                List<String> opciones = Arrays.asList(Arrays.copyOfRange(partes, 1, partes.length));         
                List<String> opcionesFaciles = opciones.subList(0, opciones.size() / 2);
                List<String> opcionesDificiles = opciones.subList((opciones.size() / 2) - 1, opciones.size());
                return new PreguntaCiencia(textoRespuesta[1], 5, opcionesFaciles, opcionesDificiles) ;
            } else if (linea.contains("::F::")) {
                String[] textoRespuesta = texto.split("::F::");  
                List<String> opciones = Arrays.asList(Arrays.copyOfRange(partes, 1, partes.length));          
                return new PreguntaDeporteFutbol(textoRespuesta[1] , 5, partes[partes.length - 2],  Integer.parseInt(partes[partes.length - 1]));
            } else if (linea.contains("::N::")) {
                String[] textoRespuesta = texto.split("::N::");  
                List<String> opciones = Arrays.asList(Arrays.copyOfRange(partes, 1, partes.length));
                return new PreguntaDeporteNatacion(textoRespuesta[1], 5, partes[partes.length - 1].contains("Verdadero"));
            } else if (linea.contains("::S::")) {
                String[] textoRespuesta = texto.split("::S::");  
                List<String> opciones = Arrays.asList(Arrays.copyOfRange(partes, 1, partes.length));
                //System.out.println(partes[partes.length - 1]);
                return new PreguntaDeporteSki(textoRespuesta[1], 5, partes[partes.length - 1].contains("Verdadero") );              
                
            } else {
                
                System.out.println("Categoría de pregunta desconocida: " + linea);
                return null;
            }
        } else {
            
            return null;
        }
    }

}
