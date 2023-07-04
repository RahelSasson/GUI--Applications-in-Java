//BS'D
//The ColorCheckBoxWindow class demonstrates how check boxes can be used
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ColorCheckBoxWindow extends JFrame {
    private JLabel label;
    private JCheckBox yellowCheckbox;
    private JCheckBox redCheckbox;
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_LENGTH = 100;

    public ColorCheckBoxWindow() {
        super();
        super.setTitle("Color Checkbox Window");
        super.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildOperations();
        super.setVisible(true);
    }

    public void buildOperations(){
        this.label = new JLabel("Select checkbox to change color");
        this.yellowCheckbox = new JCheckBox("Yellow Background");
        this.redCheckbox = new JCheckBox("Red Text");

        yellowCheckbox.addItemListener(new CheckBoxListener());
        redCheckbox.addItemListener(new CheckBoxListener());

        super.setLayout(new FlowLayout());
        super.add(label);
        super.add(yellowCheckbox);
        super.add(redCheckbox);
    }

    private class CheckBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == yellowCheckbox){
                if(yellowCheckbox.isSelected()) {
                    getContentPane().setBackground(Color.YELLOW);
                    yellowCheckbox.setBackground(Color.YELLOW);
                    redCheckbox.setBackground(Color.YELLOW);
                }
                else {
                    getContentPane().setBackground(Color.lightGray);
                    yellowCheckbox.setBackground(Color.lightGray);
                    redCheckbox.setBackground(Color.lightGray);
                }
            }
            else if(e.getSource() == redCheckbox){
                if(redCheckbox.isSelected()) {
                    getContentPane().setForeground(Color.RED);
                    label.setForeground(Color.RED);
                    yellowCheckbox.setForeground(Color.RED);
                    redCheckbox.setForeground(Color.RED);
                }
                else{
                    getContentPane().setForeground(Color.BLACK);
                    label.setForeground(Color.BLACK);
                    yellowCheckbox.setForeground(Color.BLACK);
                    redCheckbox.setForeground(Color.BLACK);
                }
            }
        }
    }

    public static void main(String[] args) {
        new ColorCheckBoxWindow();
    }

}
