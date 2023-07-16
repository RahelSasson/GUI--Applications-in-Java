//BS'D
/*
Write a GUI application that converts Celsius temperatures to Fahrenheit temperatures. The 
user should be able to enter a Celsius temperature, click a button, 
and then see the equivalent Fahrenheit temperature. 
Use the following formula to make the conversion:
F = 5/9 * C + 32
F is the Fahrenheit temperature and C is the Celsius temperature.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusToFahrenheit extends JFrame {
    private JPanel panel;
    private JLabel celsius;
    private JLabel fahrenheit;
    private JTextField userInput;
    private JButton calculate;

    public CelsiusToFahrenheit(){
        super();
        super.setTitle("Celsius to Fahrenheit Calculator");
        super.setSize(300,125);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.setVisible(true);
    }

    public void buildPanel() {
        this.panel = new JPanel();
        this.celsius = new JLabel("Celsius");
        this.userInput = new JTextField(10);
        this.fahrenheit = new JLabel("Fahrenheit:    ");

        this.calculate = new JButton("Calculate");
        calculate.addActionListener(new CalcButtonListener());

        panel.add(celsius);
        panel.add(userInput);
        panel.add(calculate);
        panel.add(fahrenheit);
    }

    private class CalcButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == calculate) {
                double fahrenheitNum = 0.0;
                double celsiusNum = 0.0;
                try {
                    celsiusNum = Double.parseDouble(userInput.getText().trim());
                }
                catch(NumberFormatException exc){
                    return;
                }

                fahrenheitNum = (1.8*celsiusNum) + 32;
                fahrenheit.setText("Fahrenheit: " + String.valueOf(fahrenheitNum));
            }
        }
    }
    public static void main(String[] args) {
        new CelsiusToFahrenheit();
    }
}
