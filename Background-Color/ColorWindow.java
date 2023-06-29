//BS'D
//Class sets the background color of a panel and the foreground color of a label.

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ColorWindow extends JFrame{
    private JLabel label;
    private JButton blueButton;
    private JButton yellowButton;
    private JButton redButton;
    private JPanel panel;
    private final int WINDOW_WIDTH = 200;
    private final int WINDOW_HEIGHT = 125;

    public ColorWindow() {
        super();
        super.setTitle("Color Window");
        super.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.setVisible(true);
    }

    public void buildPanel() {
        this.label = new JLabel("Click button to select a color");
        this.blueButton = new JButton("Blue");
        this.yellowButton = new JButton("Yellow");
        this.redButton = new JButton("Red");

        blueButton.addActionListener(new BlueButtonListener());
        yellowButton.addActionListener(new YellowButtonListener());
        redButton.addActionListener(new RedButtonListener());

        this.panel = new JPanel();
        panel.add(label);
        panel.add(blueButton);
        panel.add(yellowButton);
        panel.add(redButton);
    }

    public class BlueButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.BLUE);
            label.setForeground(Color.YELLOW);
        }
    }

    public class YellowButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.YELLOW);
            label.setForeground(Color.BLACK);
        }
    }

    public class RedButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.RED);
            label.setForeground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        new ColorWindow();
    }
}
