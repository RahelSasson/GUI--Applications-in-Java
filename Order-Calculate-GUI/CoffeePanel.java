//BS'D
import javax.swing.*;
import java.awt.*;

public class CoffeePanel extends JPanel {
    private double[] coffeeCostArr = {0.0,1.25,1.25,2.0};
    private JRadioButton[] buttons = new JRadioButton[4];
    private ButtonGroup group;

    public CoffeePanel() {
        super();
        super.setLayout(new GridLayout(4,1));
        this.buttons[0] = new JRadioButton("None");
        this.buttons[1] = new JRadioButton("Regular" , true);
        this.buttons[2] = new JRadioButton("Decaf");
        this.buttons[3] = new JRadioButton("Cappuccino");

        setBorder(BorderFactory.createTitledBorder("Coffee"));

        this.group = new ButtonGroup();

        for(int i = 0; i < buttons.length; i++){
            group.add(buttons[i]);
            super.add(buttons[i]);
        }
    }

    public double coffeeCost() {
        double coffeeCost = 0.0;

        for(int i = 0; i < buttons.length; i++)
            if(buttons[i].isSelected())
                coffeeCost += coffeeCostArr[i];

        return coffeeCost;
    }
}
