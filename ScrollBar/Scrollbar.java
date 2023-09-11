import javax.swing.*;

public class Scrollbar extends JFrame{
    JPanel panel;
    JTextField text;
    JScrollPane scroll;

    public Scrollbar() {
        super();
        super.setTitle("Scrollbar");
        super.setSize(500,500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        super.add(panel);
        super.add(scroll);
        super.setVisible(true);

    }

    public void buildPanel() {
        this.panel = new JPanel();
        this.text = new JTextField("This program demonstrates a scroll bar");
        this.scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      //  panel.add(scroll);
        panel.add(text);

    }

    public static void main(String[] args) {
        new Scrollbar();
    }

}
