//BS'D
/*
Write a GUI application that calculates a car’s gas mileage. The application should let the
user enter the number of gallons of gas the car holds, and the number of miles it can be
driven on a full tank. When a 'Calculate MPG' button is clicked, the application should
display the number of miles that the car may be driven per gallon of gas. Use the following
formula to calculate MPG:
MPG = Miles/Gallons
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MPGCalculator extends JFrame {
    private JLabel miles;
    private JLabel gallons;
    private JTextField milesText;
    private JTextField gallonsText;
    private JPanel panel;
    private JButton mpgButton;

    public MPGCalculator () {
        super();
        super.setTitle("Miles Per Gallon Calculator");
        super.setPreferredSize(new Dimension(350,200));
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.pack();
        super.setVisible(true);
    }

    public void buildPanel() {
        this.panel = new JPanel(null);

        this.miles = new JLabel("Miles :");
        miles.setBounds(25,25,80,40);
        miles.setFont(new Font("Verdana",Font.BOLD,15));
        miles.setBorder(BorderFactory.createBevelBorder(1));
        miles.setOpaque(true);

        this.gallons = new JLabel("Gallons :");
        gallons.setBounds(25,75,80,40);
        gallons.setFont(new Font("Verdana",Font.BOLD,15));
        gallons.setBorder(BorderFactory.createBevelBorder(1));
        gallons.setOpaque(true);

        this.milesText = new JTextField();
        milesText.setBounds(120,25,80,40);

        this.gallonsText = new JTextField();
        gallonsText.setBounds(120,75,80,40);

        this.mpgButton = new JButton("Calculate");
        mpgButton.setBounds(220,50,100,40);
        mpgButton.setFont(new Font("Verdana",Font.BOLD,10));
        mpgButton.setBackground(Color.YELLOW);
        mpgButton.addActionListener(new ButtonListener());

        panel.add(miles);
        panel.add(milesText);
        panel.add(gallons);
        panel.add(gallonsText);
        panel.add(mpgButton);
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mpgButton) {
                double miles = 0.0;
                double gallons = 0.0;
                try {
                    miles = Double.parseDouble(milesText.getText().trim());
                    gallons = Double.parseDouble(gallonsText.getText().trim());
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "Invalid input");
                    return;
                }
                double mpg = miles / gallons;

                JOptionPane.showMessageDialog(null, String.format("Miles Per Gallon: %,.2f", mpg));
            }
        }
    }

    public static void main(String[] args) {
        new MPGCalculator();
    }
}
