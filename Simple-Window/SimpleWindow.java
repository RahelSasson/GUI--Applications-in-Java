//BS'D
//Class extends JFrame class and displays a simple window
import javax.swing.*;
public class SimpleWindow extends JFrame{
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 250;

    public SimpleWindow() {
        super();
        super.setTitle("Simple Window");
        super.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
}
