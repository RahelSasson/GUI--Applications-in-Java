//BS'D
/*
Create a GUI application that calculates and displays the total travel expenses of a business
person on a trip. Here is the information that the user must provide:
•	 Number of days on the trip
•	 Amount of airfare, if any
•	 Amount of car rental fees, if any
•	 Number of miles driven, if a private vehicle was used
•	 Amount of parking fees, if any
•	 Amount of taxi charges, if any
•	 Conference or seminar registration fees, if any
•	 Lodging charges, per night
The company reimburses travel expenses according to the following policy:
•	 $37 per day for meals
•	 Parking fees, up to $10.00 per day
•	 Taxi charges up to $20.00 per day
•	 Lodging charges up to $95.00 per day
•	 If a private vehicle is used, $0.27 per mile driven
The application should calculate and display the following:
•	 Total expenses incurred by the business person
•	 The total allowable expenses for the trip
•	 The excess that must be paid by the business person, if any
•	 The amount saved by the business person if the expenses are under the total allowed
*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TravelExpenses extends JFrame {
    private JPanel gridPanel;
    private  JPanel buttonsPanel;
    private JLabel[] labels = new JLabel[8];
    private JTextField[] userInputs = new JTextField[8];
    private JButton enterButton;

    public TravelExpenses() {
        super.setTitle("Business Travel Expenses Calculator");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        buildGridPanel();
        buildButtonsPanel();
        super.add(gridPanel);
        super.add(buttonsPanel);
        super.pack();
        super.setVisible(true);
    }

    public void buildGridPanel() {
        this.gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(8,2));

        this.labels[0] = new JLabel("Number of days on trip:");
        this.labels[1] = new JLabel("Amount of airfare:");
        this.labels[2] = new JLabel("Amount of car rental fees:");
        this.labels[3] = new JLabel("Number of miles driven:");
        this.labels[4] = new JLabel("Amount of parking fees:");
        this.labels[5] = new JLabel("Amount of taxi charges:");
        this.labels[6] = new JLabel("Conference or Seminar fees:");
        this.labels[7] = new JLabel("Lodging charges, per night:");
        for(int i = 0; i < userInputs.length; i++) {
            this.userInputs[i] = new JTextField();
            gridPanel.add(labels[i]);
            gridPanel.add(userInputs[i]);
        }
    }

    public void buildButtonsPanel() {
        this.buttonsPanel = new JPanel();
        this.enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonListener());

        buttonsPanel.add(enterButton);
    }

    private class EnterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Enter")){
                double totalExpenses = 0.0;
                double totalAllowedExpenses = 0.0;
                double amountDue = 0.0;
                double amountSaved = 0.0;
                double[] inputArr = new double[8];
                boolean catchEvent = false;
                try {
                    for (int i = 0; i < inputArr.length; i++) {
                        if (userInputs[i].getText().equals("")){
                            inputArr[i] = 0;
                            continue;
                        }
                        inputArr[i] = Double.parseDouble(userInputs[i].getText().trim());
                    }
                    catchEvent = true;
                }
                catch(NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null,"invalid input");
                }

                while(catchEvent == true) {

                    if(inputArr[0] >= 1) {
                        inputArr[3] = inputArr[3] * 0.27; //accounting for cost of gas per mile
                        inputArr[7] = inputArr[7] * inputArr[0]; //accounting for total lodging charges

                        for (int i = 1; i < inputArr.length; i++)
                            totalExpenses += inputArr[i];
                        totalAllowedExpenses = (37 + 10 + 20 + 95) * inputArr[0] + inputArr[3];
                    }

                    if (totalAllowedExpenses >= totalExpenses) {
                        amountSaved = totalAllowedExpenses - totalExpenses;
                        JOptionPane.showMessageDialog(null,
                                String.format("Total Expenses Incurred: $%,.2f\n" +
                                        "Total Expenses Allowed: $%,.2f\n" +
                                        "Total Saved: $%,.2f" ,totalExpenses,totalAllowedExpenses,amountSaved));
                    }
                    else {
                        amountDue = totalExpenses - totalAllowedExpenses;
                        JOptionPane.showMessageDialog(null,
                                String.format("Total Expenses Incurred: $%,.2f\n" +
                                        "Total Expenses Allowed: $%,.2f\n" +
                                        "Total Owed: $%,.2f\n" , totalExpenses,totalAllowedExpenses,amountDue));
                    }
                    catchEvent = false;

                }
            }
        }
    }

    public static void main(String[] args) {
        new TravelExpenses();
    }

}
