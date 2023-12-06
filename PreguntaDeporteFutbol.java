import java.util.List;

public class PreguntaDeporteFutbol extends Pregunta{
    private List<String> listaNombre;
    private List<Integer> listaNumero;

    public PreguntaDeporteFutbol(String texto , int puntuacion, List<String> listaNombre, List<Integer> listaNumero) {
        super(texto, puntuacion);
        this.listaNombre=listaNombre;
        this.listaNumero=listaNumero;
    }

    public List<String> getListaNombre() {
        return listaNombre;
    }


    @Override
    public int getPuntuacion() {
        puntuacionBase = super.getPuntuacion();
        return puntuacionBase + 1;
    }

    public List<String> imprimeRespuestaNombre(){
        return listaNombre;
    }

    public List<Integer> imprimeRespuestaNumero(){
        return listaNumero;
    }

}
