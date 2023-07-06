//BS'D
/*
Create a GUI application where the user enters the wholesale cost of an item and its markup
percentage into text fields. (For example, if an item’s wholesale cost is $5 and its markup
percentage is 100 percent, then its retail price is $10.) The application should have a button 
that displays the item’s retail price when clicked.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RetailPriceCalculator extends JFrame {
    private final int WINDOW_LENGTH = 150;
    private final int WINDOW_WIDTH = 250;
    private JLabel label;
    private JTextField price;
    private JTextField markup;
    private JButton enterButton;

    private JPanel panel;

    public RetailPriceCalculator() {
        super();
        super.setTitle("Retail Price Calculator");
        super.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        build();
        super.add(panel);
        super.setVisible(true);
    }

    public void build() {
        this.panel = new JPanel();
        this.label = new JLabel("Enter Wholesale Cost and Markup");
        this.price = new JTextField("Price",10);
        this.markup = new JTextField("Markup Percentage",10);
        this.enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonListener());

        panel.add(label);
        panel.add(price);
        panel.add(markup);
        panel.add(enterButton);
    }

    private class EnterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Enter")){
                double priceCost = 0.0;
                double markupCost = 0.0;
                double finalPrice = 0.0;
                try {
                    priceCost = Double.parseDouble(price.getText().trim());
                    markupCost = Double.parseDouble(markup.getText().trim());
                }
                catch(NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null,"Invalid entry for price or markup");
                }

                finalPrice = priceCost + (priceCost * markupCost/100);

                JOptionPane.showMessageDialog(null, "Final Price is: " + finalPrice);
            }
        }
    }

    public static void main(String[] args) {
        new RetailPriceCalculator();
    }
}
