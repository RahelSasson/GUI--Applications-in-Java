//BS'D
/*
A county collects property taxes on the assessment value of property, which is 60 percent
of the property’s actual value. If an acre of land is valued at $10,000, its assessment value is
$6,000. The property tax is then $0.64 for each $100 of the assessment value. The tax for
the acre assessed at $6,000 will be $38.40.
Create a GUI application that displays the assessment value and property tax
when a user enters the actual value of a property.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PropertyTax extends JFrame {
    private final int WINDOW_LENGTH = 125;
    private final int WINDOW_WIDTH = 250;
    private final double propertyTax = 0.64;
    private JPanel panel;
    private JLabel label;
    private JTextField propertyValue;
    private JButton enterButton;

    public PropertyTax() {
        super();
        super.setTitle("Property Tax Calculator");
        super.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.setVisible(true);
    }

    public void buildPanel(){
        this.panel = new JPanel();
        this.label = new JLabel("Enter property value in dollar amount.");
        this.propertyValue = new JTextField(15);
        this.enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonListener());

        panel.add(label);
        panel.add(propertyValue);
        panel.add(enterButton);
    }

    private class EnterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == enterButton) {
                double propertyAssessment = 0.0;
                double propertyTaxCost = 0.0;
                double input = 0.0;

                try {
                    input = Double.parseDouble(propertyValue.getText().trim());
                    propertyAssessment = input * 0.6;
                    propertyTaxCost = propertyAssessment/100 * propertyTax;

                    JOptionPane.showMessageDialog(null,
                            String.format("Property Assessment: $%,.2f\n" +
                                            "Property Tax: $%,.2f" ,
                                    propertyAssessment,propertyTaxCost));
                }
                catch(NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null,"Invalid input for Property Value");
                }
            }
        }
    }

    public static void main(String[] args) {
        new PropertyTax();
    }
}
