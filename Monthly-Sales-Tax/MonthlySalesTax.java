//BS'D
/*
A retail company must file a monthly sales tax report listing the total sales for the month,
and the amount of state and county sales tax collected. The state sales tax rate is 4 percent
and the county sales tax rate is 2 percent. Create a GUI application that allows the user to
enter the total sales for the month into a text field. From this figure, the application should
calculate and display the following:
•	 The amount of county sales tax
•	 The amount of state sales tax
•	 The total sales tax (county plus state)
In the application’s code, represent the county tax rate (0.02) and the state tax rate (0.04)
as named constants
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MonthlySalesTax extends JFrame{
    private final int WINDOW_LENGTH = 150;
    private final int WINDOW_WIDTH = 200;
    private final double stateTax = 0.04;
    private final double countyTax = 0.02;
    private JPanel panel;
    private JLabel label;
    private JTextField totalMonthlySales;
    private JButton calculate;

    public MonthlySalesTax() {
        super();
        super.setTitle("Monthly Sales Tax Calculator");
        super.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.setVisible(true);
    }

    public void buildPanel() {
        this.panel = new JPanel();
        this.label = new JLabel("Enter total monthly sales: ");
        this.totalMonthlySales = new JTextField(15);
        this.calculate = new JButton("Calculate");
        calculate.addActionListener(new CalculateButtonListener());

        panel.add(label);
        panel.add(totalMonthlySales);
        panel.add(calculate);
    }

    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Calculate")){
                double input = 0.0;
                try {
                    input = Double.parseDouble(totalMonthlySales.getText().trim());
                }
                catch(NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null,"Invalid entry for Total Monthly Sales in Dollars");
                }
                double stateTaxCalc = input*stateTax;
                double countyTaxCalc = input*countyTax;

                JOptionPane.showMessageDialog(null,
                        String.format("County Sales Tax: $%,.4f\n" +
                                "State Sales Tax: $%,.4f\n" +
                                "Total Sales Tax: $%,.4f",countyTaxCalc,stateTaxCalc,countyTaxCalc+stateTaxCalc));
            }
        }
    }
    public static void main(String[] args) {
        new MonthlySalesTax();
    }

}
