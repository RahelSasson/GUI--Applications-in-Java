//BS'D
/*FlowLayout Arranges components in rows; this is the default layout manager for JPanel objects
•	 You can add multiple components to a container that uses a FlowLayout manager.
•	 When you add components to a container that uses a FlowLayout manager, the components appear horizontally, from left to right, in the order that they were added to
the component.
•	 When there is no more room in a row but more components are added, the new components “flow” to the next row.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FlowWindow extends JFrame {
    private final int WINDOW_WIDTH = 200;
    private final int WINDOW_LENGTH = 100;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public FlowWindow() {
        super();
        super.setTitle("Flow Layout");
        super.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());

        this.button1 = new JButton("Button 1");
        this.button2 = new JButton("Button 2");
        this.button3 = new JButton("Button 3");

        super.add(button1);
        super.add(button2);
        super.add(button3);

        super.setVisible(true);
    }

    public static void main(String[] args) {
        new FlowWindow();
    }
}
