import java.util.List;

public class Pregunta {

    protected String texto;
    protected int puntuacionBase;

    public Pregunta(String texto, int pontuacaoBase) {
        this.texto = texto;
        this.puntuacionBase = pontuacaoBase;
    }

    public String getTexto() {
        return texto;
    }

    public int getPuntuacion() {
        return puntuacionBase;
    }

    public void mostrarRespuesta(){

    }

}
