
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class Interfaz extends Component {
    private JFrame frame;
    private JLabel labelPregunta;
    private JRadioButton opcion1, opcion2, opcion3, opcion4, opcion5, opcionVerdadero, opcionFalso;
    private JButton botonSiguiente;
    private int puntuacion = 10; //QUITARLO DESPUESSS
    private ArrayList<Integer> mejoresPuntuaciones = new ArrayList<>();

    private int cont=0;
    private ButtonGroup group;
    private ActionListener botonSiguienteListener;

    public void crearVentana(Pregunta pregunta) {
        frame = new JFrame();
        frame.setTitle("Preguntas");
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        group = new ButtonGroup();  // Inicializa el ButtonGroup aquí

        botonSiguiente = new JButton("Siguiente");
        botonSiguienteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta(pregunta);
            }
        };
        botonSiguiente.addActionListener(botonSiguienteListener);

        pregunta(pregunta);  // Mueve la lógica de pregunta a este método

        frame.add(botonSiguiente);
        frame.setVisible(true);
    }

    public void actionListener(ActionEvent e, Pregunta pregunta){
        if(e.getSource()==botonSiguiente){
                cont=cont+1;
                pregunta(pregunta);
                if(cont==5){
                    preguntarDatosJugador();

            }
        }
    }

    public void pregunta(Pregunta pregunta) {
        limpiarPantalla(); // Limpia la pantalla antes de agregar nuevos componentes

        if(pregunta.getOpciones().size() == 3) {
            pregunta3Opciones(pregunta);
        } else if(pregunta.getOpciones().size() == 2) {
            preguntaVerdaderoFalso(pregunta);
        } else if(pregunta.getOpciones().size() > 3) {
            preguntaMuhasOpciones(pregunta);
        }

        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.addActionListener(botonSiguienteListener);

        frame.add(botonSiguiente);
        frame.setVisible(true);

    }

    /*private ActionListener siguientePreguntaListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarPantalla();

           sigPregunta();
            if (siguientePregunta != null) {
                mostrarSiguientePregunta(siguientePregunta);
            } else {

                JOptionPane.showMessageDialog(frame, "¡Fin del cuestionario!");
            }
        }
    };*/



    private void preguntarDatosJugador() {
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese su nombre completo:");

        mostrarTop3();

        int opcion = JOptionPane.showOptionDialog(
                null,
                "¿Desea comenzar un nuevo juego o salir?",
                "Opciones",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Nuevo Juego", "Salir"},
                "Nuevo Juego");

        if (opcion == JOptionPane.YES_OPTION) {


        } else {
            System.exit(0);
        }

    }


    private void mostrarTop3() {

        mejoresPuntuaciones = new ArrayList<>();

        // Agregar manualmente puntuaciones
        mejoresPuntuaciones.add(10);
        mejoresPuntuaciones.add(8);
        mejoresPuntuaciones.add(12);

        StringBuilder mensaje = new StringBuilder("TOP 3 Puntuaciones:\n");
        for (int i = 0; i < Math.min(3, mejoresPuntuaciones.size()); i++) {
            mensaje.append(i + 1).append(". ")
                    .append("Puntuación: ").append(mejoresPuntuaciones.get(i)).append(" puntos\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "TOP 3", JOptionPane.INFORMATION_MESSAGE);
    }


    public void pregunta3Opciones(Pregunta pregunta) {
        labelPregunta = new JLabel(pregunta.getTexto());
        opcion1 = new JRadioButton(pregunta.getOpciones().get(0));
        opcion2 = new JRadioButton(pregunta.getOpciones().get(1));
        opcion3 = new JRadioButton(pregunta.getOpciones().get(2));

        opcion2.setActionCommand("correcta");

        group.add(opcion1);
        group.add(opcion2);
        group.add(opcion3);


        frame.setLayout(new GridLayout(5, 1));
        frame.add(labelPregunta);
        frame.add(opcion1);
        frame.add(opcion2);
        frame.add(opcion3);

    }

    public void mostrarSiguientePregunta(Pregunta sigPregunte) {

        limpiarPantalla();

        // Mostrar la siguiente pregunta en la misma ventana
        if (sigPregunte.getOpciones().size() == 3) {
            pregunta3Opciones(sigPregunte);
        } else if (sigPregunte.getOpciones().size() == 2) {
            preguntaVerdaderoFalso(sigPregunte);
        } else if (sigPregunte.getOpciones().size() > 3) {
            preguntaMuhasOpciones(sigPregunte);
        }
    }

    private void verificarRespuesta(Pregunta pregunta) {
        if (group.getSelection() != null && group.getSelection().getActionCommand() != null && group.getSelection().getActionCommand().equals("correcta")) {

            JOptionPane.showMessageDialog(frame, "¡Respuesta correcta!, su puntuacion es: " + puntuacion + " puntos");

        } else {
            JOptionPane.showMessageDialog(frame, "Respuesta incorrecta!, la respuesta correcta era " +pregunta.getRespuesta()+" su puntuacion es: " + puntuacion + " puntos");
        }

    }



    private void limpiarPantalla() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
    }
    public void preguntaVerdaderoFalso(Pregunta pregunta) {
        labelPregunta = new JLabel(pregunta.getTexto());
        opcionVerdadero = new JRadioButton("Verdadero");
        opcionFalso = new JRadioButton("Falso");

        opcionVerdadero.setActionCommand("correcta");

        group.add(opcionVerdadero);
        group.add(opcionFalso);


        frame.setLayout(new GridLayout(5, 1));
        frame.add(labelPregunta);
        frame.add(opcionVerdadero);
        frame.add(opcionFalso);

    }

    //cambiar el numero de opciones segun el q tegamos
    public void preguntaMuhasOpciones(Pregunta pregunta) {
        labelPregunta = new JLabel(pregunta.getTexto());
        group = new ButtonGroup();

        for (int i = 0; i < pregunta.getOpciones().size(); i++) {
            JRadioButton opcion = new JRadioButton(pregunta.getOpciones().get(i));
            group.add(opcion);
            frame.add(opcion);
        }



        frame.setLayout(new GridLayout(pregunta.getOpciones().size() + 2, 1));
        frame.add(labelPregunta);

        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            frame.add(buttons.nextElement());
        }

    }

}




