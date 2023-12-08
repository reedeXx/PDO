import java.util.List;

public class PreguntaCiencia extends Pregunta{

    private List<String> opFac;
    private List<String> opDif;    
    


    public PreguntaCiencia(String texto, int pontuacaoBase ) {
        super(texto, pontuacaoBase);
    }

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
    public void mostrarRespuesta() {
        
        
        System.out.println("Opciones: \n");
        for ( int i=0 ; i < opDif.size() ; i++ )
            System.out.println(opDif.get(i));
        for ( int i=0 ; i < opFac.size() ; i++ )
            System.out.println(opFac.get(i));
            
    }


    @Override
    public int getPuntuacion() {
        return puntuacionBase + 5;
    }

}
