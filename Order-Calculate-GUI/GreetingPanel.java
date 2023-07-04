//BS'D
import javax.swing.*;

public class GreetingPanel extends JPanel {
    private JLabel greeting;

    public GreetingPanel() {
        this.greeting = new JLabel("Welcome to Brandis Bagel Shop");
        super.add(greeting);
    }
}
