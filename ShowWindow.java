import javax.swing.*;
import javax.swing.*;

public class ShowWindow {
    public static void main(String[] args) {
        final int WINDOW_LENGTH = 250;
        final int WINDOW_WIDTH = 350;

        JFrame window = new JFrame();
        window.setTitle("Simple Window");
        window.setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }
}
