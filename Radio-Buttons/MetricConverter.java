//BS'D
/*
The MetricConverter class lets the user enter a
distance in kilometers. Radio buttons can be selected to
convert the kilometers to miles, feet, or inches.
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MetricConverter extends JFrame {
    private JPanel panel;
    private JTextField userInput;
    private JLabel label;
    private JRadioButton milesButton;
    private JRadioButton feetButton;
    private JRadioButton inchesButton;
    private JButton enterButton;
    private ButtonGroup radioButtonGroup;
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 100;

    public MetricConverter() {
        super();
        super.setTitle("Metric Converter");
        super.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.setVisible(true);
    }

    public void buildPanel() {
        this.panel = new JPanel();
        this.label = new JLabel("Enter a distance in kilometers: ");
        this.userInput = new JTextField(10);
        this.milesButton = new JRadioButton("  Miles");
        this.feetButton = new JRadioButton("  Feet",true);
        this.inchesButton = new JRadioButton("  Inches");
        this.enterButton = new JButton("Enter");

        //The function of a ButtonGroup object is to
        //deselect all the other radio buttons when one of them is selected.
        this.radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(milesButton);
        radioButtonGroup.add(feetButton);
        radioButtonGroup.add(inchesButton);

        milesButton.addActionListener(new RadioButtonListener());
        feetButton.addActionListener(new RadioButtonListener());
        inchesButton.addActionListener(new RadioButtonListener());
        enterButton.addActionListener(new RadioButtonListener());

        panel.add(label);
        panel.add(userInput);
        panel.add(milesButton);
        panel.add(feetButton);
        panel.add(inchesButton);
        panel.add(enterButton);
    }

    private class RadioButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double result = 0.0;
            if(e.getSource() == enterButton) {
                if (milesButton.isSelected())
                    result = Double.parseDouble(userInput.getText()) * 0.6214;
                else if (feetButton.isSelected())
                    result = Double.parseDouble(userInput.getText()) * 3281.0;
                else if (inchesButton.isSelected())
                    result = Double.parseDouble(userInput.getText()) * 39370.0;

                JOptionPane.showMessageDialog(null, result);
            }
        }
    }

    public static void main(String[] args) {
        new MetricConverter();
    }

}
