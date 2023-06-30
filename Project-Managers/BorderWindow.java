//BS'D
/*
BorderLayout Arranges components in five regions: north, south, east, west, and center;
this is the default layout manager for a JFrame object’s content pane.
--When adding a component to the container, you specify the
region by passing one of the following constants as a second argument to the container’s
add method: BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.EAST, BorderLayout.WEST, or BorderLayout.CENTER.
--If you do not pass a second argument to the add method, the component will be added to the center region.
•	 Each region can hold only one component at a time.
•	 When a component is added to a region, the component is stretched so it fills up the entire region.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BorderWindow extends JFrame {
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_LENGTH = 300;

    public BorderWindow() {
        super();
        super.setTitle("Border Layout");
        super.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         There is no gap between the regions. You can use an overloaded version of the
         BorderLayout constructor to specify horizontal and vertical gaps, however.
         Here is the constructor’s format:
         BorderLayout(int horizontalGap, int verticalGap)
         */
        super.setLayout(new BorderLayout(10,5));

        JPanel panel1 = new JPanel();

        JButton northButton = new JButton("Northern Button");
        JButton westButton = new JButton("Western Button");
        JButton eastButton = new JButton("Eastern Button");
        JButton centerButton = new JButton("Central Button");
        JButton southButton = new JButton("Southern Button");

        //by creating a panel and adding the first button to the panel, we can avoid the resizing of the component.
        panel1.add(northButton);

        super.add(panel1,BorderLayout.NORTH);
        super.add(westButton,BorderLayout.WEST);
        super.add(eastButton,BorderLayout.EAST);
        super.add(centerButton,BorderLayout.CENTER);
        super.add(southButton,BorderLayout.SOUTH);

        /*
        If we want to avoid using JFrame.setSize() ; we can use the pack() method in its stead;
        The pack method, which is inherited from JFrame,
        automatically sizes the window to accommodate the components contained within it.
        super.pack();
         */
        super.setVisible(true);
    }

    public static void main(String[] args){
        new BorderWindow();
    }
}
