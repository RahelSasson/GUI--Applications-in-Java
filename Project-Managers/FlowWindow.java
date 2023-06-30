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
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_LENGTH = 300;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public FlowWindow() {
        super();
        super.setTitle("Flow Layout");
        super.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //alignment
        super.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        /*
        The FlowLayout manager inserts a gap of five pixels between components, both
        horizontally and vertically. You can adjust this gap by passing values for the horizontal and
        vertical gaps as arguments to an overloaded FlowLayout constructor. The constructor has
        the following format:
        FlowLayout(int alignment, int horizontalGap, int verticalGap)
         */

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
