import java.util.List;

public class PreguntaArtes extends Pregunta{

    public PreguntaArtes(String texto, int puntos, List<String> opc, String sol, String categoria ){
        super(texto, puntos, opc, sol, categoria  );
    }

    public String getTexto() {
        return super.getTexto();
    }

    public int getPuntuacion() {
        return super.getPuntuacion();
    }

    public String getCategoria(){return super.getCategoria();}

    public String getRespuesta(){
        return super.getRespuesta();
    }

    public List<String> getOpciones() {
        return super.getOpciones();
    }

    public int calcularTotalPreguntas(){
        return opc.size();
    }
}
