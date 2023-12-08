import java.util.List;

public class PreguntaDeporteFutbol extends PreguntaDeporte{
    private String listaNombre;
    private int listaNumero;

    public PreguntaDeporteFutbol(String texto , int puntuacion ) {
        super(texto, puntuacion);
    }

    public PreguntaDeporteFutbol(String texto , int puntuacion, String listaNombre, int listaNumero) {
        super(texto, puntuacion);
        this.listaNombre=listaNombre;
        this.listaNumero=listaNumero;
    }

    public String getListaNombre() {
        return listaNombre;
    }

    @Override
    public void mostrarRespuesta() {

        System.out.println(listaNombre);
        System.out.println(listaNumero);
    
    }

    @Override
    public int getPuntuacion() {
        puntuacionBase = super.getPuntuacion();
        return puntuacionBase + 1;
    }

    public int getRespuestaNumero(){
        return listaNumero;
    }

}
