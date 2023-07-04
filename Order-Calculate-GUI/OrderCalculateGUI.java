//BS'D

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class OrderCalculateGUI extends JFrame {
    private GreetingPanel greeting;
    private BagelPanel bagel;
    private ToppingPanel toppings;
    private CoffeePanel coffee;
    private JPanel buttonsPanel;
    private JButton calculateButton;
    private JButton exitButton;
    private final double SALES_TAX = 0.06;

    public OrderCalculateGUI() {
        super();
        super.setTitle("Order Calculator");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());

        this.greeting = new GreetingPanel();
        this.bagel = new BagelPanel();
        this.toppings = new ToppingPanel();
        this.coffee = new CoffeePanel();

        buildButtonPanel();

        super.add(greeting,BorderLayout.NORTH);
        super.add(bagel,BorderLayout.WEST);
        super.add(toppings,BorderLayout.CENTER);
        super.add(coffee,BorderLayout.EAST);
        super.add(buttonsPanel,BorderLayout.SOUTH);

        super.pack();
        super.setVisible(true);
    }

    public void buildButtonPanel(){
        this.buttonsPanel = new JPanel();

        this.calculateButton = new JButton("Calculate");
        this.exitButton = new JButton("Exit");

        calculateButton.addActionListener(new ButtonListener());
        exitButton.addActionListener(new ButtonListener());

        buttonsPanel.add(calculateButton);
        buttonsPanel.add(exitButton);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == calculateButton) {
                double subtotal = bagel.bagelCost() + toppings.toppingsCost() + coffee.coffeeCost();
                double tax = subtotal * SALES_TAX;
                double total = subtotal + tax;

                JOptionPane.showMessageDialog(null,
                        String.format("Subtotal : $%,.2f\n" +
                                "Tax : $%,.2f\n" +
                                "Total : $%,.2f" ,
                                subtotal,tax,total));
            }
            else if(e.getSource() == exitButton)
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        new OrderCalculateGUI();
    }
}
