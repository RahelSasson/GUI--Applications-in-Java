//BS'D
//getActionCommand() Returns the action command for this event as a String
//getSource() Returns a reference to the object that generated this event

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventObjectWindow extends JFrame {

    private JButton button1;
    private JButton button2;
    private  JButton button3;
    private JPanel panel;
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 105;

    public EventObjectWindow() {
        super();
        super.setTitle("Event Object Window");
        super.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPanel();
        super.add(panel);
        super.setVisible(true);
    }

    private void setPanel() {
        this.button1 = new JButton("Button 1");
        this.button2 = new JButton("Button 2");
        this.button3 = new JButton("Button 3");

        button1.addActionListener(new ButtonListener());
        button2.addActionListener(new ButtonListener());
        button3.addActionListener(new ButtonListener());

        this.panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Button 1"))
                JOptionPane.showMessageDialog(null,"You chose the first button");
            else if(e.getSource() == button2 )
                JOptionPane.showMessageDialog(null, "You chose the second button");
            else
                JOptionPane.showMessageDialog(null, "You chose the third button");
            return;
        }
    }

    public static void main(String[] args) {
        new EventObjectWindow();
    }

}
