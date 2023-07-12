//BS'D
/*
Look at the following list of Latin words and their meanings.
Latin English
sinister left
dexter right
medium center
Write a GUI application that translates the Latin words to English. The window should
have three buttons, one for each Latin word. When the user clicks a button, the program
displays the English translation in a label.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LatinTranslator extends JFrame {
    private JLabel englishLabel;
    private JLabel latinLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel translation1;
    private JLabel translation2;
    private JLabel translation3;
    private JPanel panel;
    private boolean hasBeenClicked1 = false;
    private boolean hasBeenClicked2 = false;
    private boolean hasBeenClicked3 = false;

    public LatinTranslator() {
        super();
        super.setTitle("Latin Translator");
        super.setSize(450,450);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.pack();
        super.setVisible(true);
    }

    public void buildPanel(){
        this.panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        this.latinLabel = new JLabel("Latin");
        latinLabel.setFont(new Font("Ink Free",Font.BOLD,20));
        this.englishLabel = new JLabel(" English");
        englishLabel.setFont(new Font("Ink Free",Font.BOLD,20));

        this.button1 = new JButton("Sinister");
        this.button2 = new JButton("Dexter");
        this.button3 = new JButton("Medium");

        button1.addActionListener(new ButtonListener());
        button2.addActionListener(new ButtonListener());
        button3.addActionListener(new ButtonListener());

        this.translation1 = new JLabel(" ");
        this.translation2 = new JLabel(" ");
        this.translation3 = new JLabel(" ");


        panel.add(latinLabel);
        panel.add(englishLabel);
        panel.add(button1);
        panel.add(translation1);
        panel.add(button2);
        panel.add(translation2);
        panel.add(button3);
        panel.add(translation3);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == button1) {
                if(!hasBeenClicked1) {
                    translation1.setText("Left");
                    translation1.setHorizontalAlignment(JTextField.CENTER);
                    hasBeenClicked1 = true;
                }
                else {
                    translation1.setText(" ");
                    hasBeenClicked1 = false;
                }
            }
            else if(e.getSource() == button2) {
                if(!hasBeenClicked2){
                translation2.setText("Right");
                translation2.setHorizontalAlignment(JTextField.CENTER);
                hasBeenClicked2 = true;
                }
                else {
                    translation2.setText(" ");
                    hasBeenClicked2 = false;
                }
            }
            else if(e.getSource() == button3){
                if(!hasBeenClicked3){
                translation3.setText("Center");
                translation3.setHorizontalAlignment(JTextField.CENTER);
                hasBeenClicked3 = true;
                }
                else {
                    translation3.setText(" ");
                    hasBeenClicked3 = false;
                }
            }

        }
    }
    public static void main(String[] args) {
        new LatinTranslator();
    }
}
