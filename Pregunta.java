import java.util.List;

public abstract class Pregunta {

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

    public abstract void mostrarRespuesta();

}
