import java.util.List;

public class PreguntaArtes extends Pregunta{

    private List<String> opcCorrectas;
    private List<String> lista3Opc;
    public PreguntaArtes(String texto, int puntuacion, List<String> opcCorrectas, List<String> lista3Opc) {
        super(texto, puntuacion);
        this.opcCorrectas=opcCorrectas;
        this.lista3Opc=lista3Opc;
    }

    @Override
    public int getPuntuacion() {
        puntuacionBase = super.getPuntuacion();
        return puntuacionBase * 10;
    }

    public List<String> imprimeRespuestaNombre(){
        return lista3Opc;
    }

    public List<String> imprimeOpcCorrecta(){
        return opcCorrectas;
    }
}
