
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tiempo implements ActionListener {
    private JLabel labelTiempo;
    private Timer timer;
    private int segundos = 0, minutos = 0, horas = 0;

    public Tiempo() {
        labelTiempo = new JLabel("00:00:00");
        labelTiempo.setFont(new Font("Arial", Font.PLAIN, 72));

        JFrame frame = new JFrame("Cronómetro");
        frame.setLayout(new GridLayout(1, 1));
        frame.add(labelTiempo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }
                if (minutos == 60) {
                    minutos = 0;
                    horas++;
                }
                actualizarLabelTiempo();
            }
        });
    }

    private void actualizarLabelTiempo() {
        labelTiempo.setText(String.format("%02d:%02d:%02d", horas, minutos, segundos));
    }

    public void iniciarCronometro() {
        timer.start();
    }
    public void detenerCronometro() {
        timer.stop();
        System.out.println("\n\nEl tiempo que duro la partida es de: "+labelTiempo.getText()+"\n\n");
        labelTiempo.setText(String.format("00:00:00"));
        segundos = 0;
        minutos = 0;
        horas = 0; 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
