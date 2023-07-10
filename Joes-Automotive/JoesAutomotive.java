//BS'D
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Joe’s Automotive performs the following routine maintenance services:
•	 Oil change—$26.00
•	 Lube job—$18.00
•	 Radiator flush—$30.00
•	 Transmission flush—$80.00
•	 Inspection—$15.00
•	 Muffler replacement—$100.00
•	 Tire rotation—$20.00
Joe also performs other nonroutine services and charges for parts and for labor ($20 per
hour). Create a GUI application that displays the total for a customer’s visit to Joe’s.
 */

public class JoesAutomotive extends JFrame {
    private final double[] costsArr = {26,18,30,80,15,100,20};
    private JPanel servicesPanel;
    private JPanel partsAndLaborPanel;
    private final String[] servicesArr = {"Oil Change","Lubrication","Radio Flush","Transmission Flush",
                                        "Inspection","Muffler Replacement","Tire Rotation"};
    private JCheckBox[] checkBoxes = new JCheckBox[7];
    private JRadioButton yesButton;
    private JRadioButton noButton;
    private ButtonGroup group;
    private JLabel partsAndLabor;
    private JTextField partsAndLaborInput;
    private JButton calculate;

    public JoesAutomotive() {
        super();
        super.setTitle("Joe's Automotive");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        buildServicesPanel();
        buildPartsAndLaborPanel();
        super.add(servicesPanel,BorderLayout.WEST);
        super.add(partsAndLaborPanel,BorderLayout.EAST);
        super.add(calculate,BorderLayout.SOUTH);
        super.pack();
        super.setVisible(true);
    }

    public void buildServicesPanel() {
        this.servicesPanel = new JPanel();
        servicesPanel.setLayout(new GridLayout(7,1));
        servicesPanel.setBorder(BorderFactory.createTitledBorder("Services"));
        for(int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox(servicesArr[i]);
            servicesPanel.add(checkBoxes[i]);
        }
    }

    public double servicesCost() {
        double servicesCost = 0.0;
        for(int i = 0; i < checkBoxes.length; i++) {
            if(checkBoxes[i].isSelected())
                servicesCost += costsArr[i];
        }
        return servicesCost;
    }

    public void buildPartsAndLaborPanel(){
        this.partsAndLaborPanel = new JPanel();
        this.partsAndLabor = new JLabel("Request additional service? (if yes,how many hours?)");
        partsAndLaborPanel.setLayout(new GridLayout(4,1));
        this.partsAndLaborInput = new JTextField();

        this.yesButton = new JRadioButton("Yes");
        this.noButton = new JRadioButton("No");
        this.group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);

        this.calculate = new JButton("Calculate");
        calculate.addActionListener( new CalcButtonListener());

        partsAndLaborPanel.add(partsAndLabor);
        partsAndLaborPanel.add(yesButton);
        partsAndLaborPanel.add(noButton);
        partsAndLaborPanel.add(partsAndLaborInput);
    }

    private class CalcButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == calculate) {
                double servicesCosts = servicesCost();
                double extraServicesCosts = 0.0;
                double hours = 0.0;
                if(yesButton.isSelected()){
                    try{
                        hours = Double.parseDouble(partsAndLaborInput.getText().trim());
                    }
                    catch(NumberFormatException exc) {
                        JOptionPane.showMessageDialog(null,"Invalid input for additional hours of services");
                        return;
                    }
                }
                extraServicesCosts = hours * 20;
                double totalCosts = servicesCosts + extraServicesCosts;

                JOptionPane.showMessageDialog(null,
                        String.format("Services costs: $%,.2f\n" +
                                "Extra hours requested: $%,.2f\n" +
                                "Extra services costs: $%,.2f\n" +
                                "Total services costs: $%,.2f", servicesCosts,hours,extraServicesCosts,totalCosts));

            }
        }
    }

    public static void main(String[] args) {
        new JoesAutomotive();
    }
}
