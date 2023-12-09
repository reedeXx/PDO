import java.util.List;
import java.util.Random;

public class Pregunta {

    protected String texto;
    protected int puntuacionBase;
    List<String> opc;
    String sol;
    String categoria;

    public Pregunta(String texto, int pontuacaoBase, List<String> opc, String sol, String categoria) {
        this.texto=texto;
        this.puntuacionBase=pontuacaoBase;
        this.opc=opc;
        this.sol=sol;
        this.categoria=categoria;

    }

    public String getTexto() {
        return texto;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void mezclarOpciones() {
        Random random = new Random();
        for (int i = opc.size()-1; i > 0; i--) {
            int j = random.nextInt(i + 1);


            String temp = opc.get(i);
            opc.set(i, opc.get(j));
            opc.set(j, temp);
        }
    }



    public int getCantidadOpciones() {
        return opc.size();
    }

    public int getPuntuacion() {
        return puntuacionBase;
    }

    public String getRespuesta(){
        return sol;
    }

    public List<String> getOpciones() {
        return this.opc;
    }
}
