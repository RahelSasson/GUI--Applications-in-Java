//BS'D
//Class extends JFrame class and converts inout distance from km to miles
import javax.swing.*;
import java.awt.event.*;

public class KiloConverter extends JFrame{
    private final int WINDOW_HEIGHT = 130;
    private final int WINDOW_WIDTH = 350;
    private JPanel panel;
    private JLabel label;
    private JTextField kiloText;
    private JButton button;


    public KiloConverter() {
        super();
        super.setTitle("Kilo to Miles Converter");
        super.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.setVisible(true);
    }

    public void buildPanel() {
        this.label = new JLabel("Enter numerical value in kilometers:");
        this.kiloText = new JTextField(10);
        this.button = new JButton("calculate");
        buttonListener listener = new buttonListener();
        button.addActionListener(listener);

        this.panel = new JPanel();
        panel.add(label);
        panel.add(kiloText);
        panel.add(button);
    }

    private class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String input = kiloText.getText();
            input.trim();
            double miles = 0;
            try {
                 miles = Double.parseDouble(input) * 0.6214;
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Invalid input (" + input + ")" );
                return;
            }

            JOptionPane.showMessageDialog(null,miles + " Miles");
            return;
        }
    }

    public static void main(String[] args) {
        new KiloConverter();
    }
}
