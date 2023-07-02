//BS'D
/*
GridLayout Arranges components in a grid with rows and columns.
The GridLayout manager creates a grid with rows and columns, much like a spreadsheet. As
a result, the container that is managed by a GridLayout object is divided into equally sized
cells.
•	 Each cell can hold only one component.
•	 All of the cells are the same size. This is the size of the largest component placed within the layout.
•	 A component that is placed in a cell is automatically resized to fill up any extra space.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GridWindow extends JFrame{
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_LENGTH = 200;

    public GridWindow(){
        super();
        super.setTitle("Grid Layout");
        super.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        You pass the number of rows and columns that a container should have as arguments to the
        GridLayout constructor.
        Here is the general format of the constructor:
        GridLayout(int rows, int columns)
         */
        super.setLayout(new GridLayout(2,3));
        buildPanel();
        super.setVisible(true);
    }

    public void buildPanel() {
        JButton[] buttons = new JButton[6];
        for(int i = 0; i < buttons.length; i++)
            buttons[i] = new JButton("Button " + (i+1));

        JLabel[] labels = new JLabel[6];
        for(int i = 0; i < labels.length; i++)
            labels[i] = new JLabel("This is cell " + (i+1));

        JPanel[] panels = new JPanel[6];
        for(int i = 0; i < panels.length; i++){
            panels[i] = new JPanel();
            panels[i].add(labels[i]);
            panels[i].add(buttons[i]);
            super.add(panels[i]);
        }
        return;
    }

    public static void main(String[] args) {
        new GridWindow();
    }
}
