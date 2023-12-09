import java.util.ArrayList;
import java.util.List;

public class PreguntaCiencia extends Pregunta{



    public PreguntaCiencia(String texto, int pontuacaoBase,List<String> opciones, String sol, String categoria ) {
        super(texto, pontuacaoBase, opciones, sol,  categoria );

    }
    public String getTexto() {
        return super.getTexto();
    }

    public String getCategoria(){return super.getCategoria();}

    public int getPuntuacion() {
        return super.getPuntuacion();
    }

    public String getRespuesta(){
        return super.getRespuesta();
    }

    public List<String> getOpciones() {
        return super.getOpciones();
    }

}
