import java.util.List;

public class PreguntaArtes extends Pregunta{

    private List<String> listaOpciones;
    private String opCorrecta;
    private List<String> lista3Opc;


    public PreguntaArtes(String texto, int puntuacion) {
        super(texto, puntuacion);
    }

    public PreguntaArtes(String texto, int puntuacion, String opCorrecta,  List<String> opciones, List<String> lista3Opc) {
        super(texto, puntuacion);
        this.listaOpciones=opciones;
        this.lista3Opc=lista3Opc;
        this.opCorrecta = opCorrecta;
    }

    @Override
    public int getPuntuacion() {
        puntuacionBase = super.getPuntuacion();
        return puntuacionBase * 10;
    }

    @Override
    public void mostrarRespuesta() {
        System.out.println("Opciones: ");

        for ( int i=0 ; i < listaOpciones.size() ; i++ )
            System.out.println(listaOpciones.get(i));
    
    }

    public List<String> getRespuestaNombre(){
        return lista3Opc;
    }

    public List<String> getOpciones(){
        return listaOpciones;
    }

    public String getCorrecta(){

        return opCorrecta;

    }
}
