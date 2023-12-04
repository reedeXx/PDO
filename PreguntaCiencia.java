import java.util.List;

public class PreguntaCiencia extends Pregunta{

    private List<String> opFac;
    private List<String> opDif;    

    public PreguntaCiencia(String texto, int pontuacaoBase, List<String> opcoesFaceis, List<String> opcoesDificeis) {
        super(texto, pontuacaoBase);
        this.opFac = opcoesFaceis;
        this.opDif = opcoesDificeis;
    }

    public List<String> getOpFac() {
        return opFac;
    }

    public List<String> getOpDif() {
        return opDif;
    }

    @Override
    public int getPuntuacion() {
        return puntuacionBase + 5;
    }

}