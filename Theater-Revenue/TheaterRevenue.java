//BS'D
/*
A movie theater only keeps a percentage of the revenue earned from ticket sales. The remainder goes to the movie company. Create a GUI application that allows the user to enter
the following data into text fields:
•	 Price per adult ticket
•	 Number of adult tickets sold
•	 Price per child ticket
•	 Number of child tickets sold
The application should calculate and display the following data for one night’s box office
business at a theater:
•	 Gross revenue for adult tickets sold. This is the amount of money taken in for all adult
tickets sold.
•	 Net revenue for adult tickets sold. This is the amount of money from adult ticket sales
left over after the payment to the movie company has been deducted.
•	 Gross revenue for child tickets sold. This is the amount of money taken in for all child
tickets sold.
•	 Net revenue for child tickets sold. This is the amount of money from child ticket sales
left over after the payment to the movie company has been deducted.
•	 Total gross revenue. This is the sum of gross revenue for adult and child tickets sold.
•	 Total net revenue. This is the sum of net revenue for adult and child tickets sold.
Assume the theater keeps 20 percent of its box office receipts. Use a constant in your code
to represent this percentage.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheaterRevenue extends JFrame {
    private final double theaterProfits = 0.2;
    private JPanel panel;
    private JPanel userInputsPanel;
    private JLabel adultTicketPrice;
    private JLabel childTicketPrice;
    private JLabel adultTicketsSold;
    private JLabel childTicketsSold;
    private JTextField[] inputs = new JTextField[4];
    private  JButton enterButton;

    public TheaterRevenue() {
        super();
        super.setTitle("Theater Revenue Calculator");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        buildUserInputsPanel();
        buildPanel();
        super.add(userInputsPanel);
        super.add(panel);
        super.pack();
        super.setVisible(true);
    }

    public void buildUserInputsPanel(){
        this.userInputsPanel = new JPanel();
        userInputsPanel.setLayout(new GridLayout(4,2));
        this.adultTicketPrice = new JLabel("Adult ticket price");
        this.childTicketPrice = new JLabel("Child ticket price");
        this.adultTicketsSold = new JLabel("Adult tickets sold");
        this.childTicketsSold = new JLabel("Child tickets sold");
        for(int i = 0; i < inputs.length; i++) {
            this.inputs[i] = new JTextField();
        }
        userInputsPanel.add(adultTicketPrice);
        userInputsPanel.add(inputs[0]);
        userInputsPanel.add(childTicketPrice);
        userInputsPanel.add(inputs[1]);
        userInputsPanel.add(adultTicketsSold);
        userInputsPanel.add(inputs[2]);
        userInputsPanel.add(childTicketsSold);
        userInputsPanel.add(inputs[3]);
    }

    public void buildPanel(){
        this.panel = new JPanel();
        this.enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonListener());
        panel.add(enterButton);
    }

    private class EnterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == enterButton) {
                double adultTicketsSoldGross = 0.0;
                double childTicketsSoldGross = 0.0;
                double adultTicketsSoldNet = 0.0;
                double childTicketsSoldNet = 0.0;
                double totalGross = 0.0;
                double totalNet = 0.0;

                double priceChildTicket = 0.0;
                double priceAdultTicket = 0.0;
                double childTicketsSoldT = 0.0;
                double adultTicketsSoldT = 0.0;
                try {
                    priceAdultTicket = Double.parseDouble(inputs[0].getText().trim());
                    priceChildTicket = Double.parseDouble(inputs[1].getText().trim());
                    adultTicketsSoldT = Double.parseDouble(inputs[2].getText().trim());
                    childTicketsSoldT = Double.parseDouble(inputs[3].getText().trim());
                }
                catch(NumberFormatException exc){
                    JOptionPane.showMessageDialog(null,"Invalid input for one of the input values");
                    return;
                }
                adultTicketsSoldGross = priceAdultTicket * adultTicketsSoldT;
                childTicketsSoldGross = priceChildTicket * childTicketsSoldT;
                adultTicketsSoldNet = adultTicketsSoldGross * theaterProfits;
                childTicketsSoldNet = childTicketsSoldGross * theaterProfits;
                totalGross = adultTicketsSoldGross + childTicketsSoldGross;
                totalNet = adultTicketsSoldNet + childTicketsSoldNet;

                JOptionPane.showMessageDialog(null,
                        String.format("Gross Adult Ticket Sales: $%,.2f\n" +
                                "Gross Child Ticket Sales: $%,.2f\n" +
                                "Total Gross Profits: $%,.2f\n" +
                                "Net Adult Ticket Sales: $%,.2f\n" +
                                "Net Child Ticket Sales: $%,.2f\n" +
                                "Total Net Profits: $%,.2f",
                                adultTicketsSoldGross,childTicketsSoldGross,totalGross,
                                adultTicketsSoldNet,childTicketsSoldNet,totalNet));
            }
        }
    }

    public static void main(String[] args) {
        new TheaterRevenue();
    }
}
