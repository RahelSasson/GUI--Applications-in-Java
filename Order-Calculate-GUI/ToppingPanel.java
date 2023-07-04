//BS'D
import javax.swing.*;
import java.awt.*;

public class ToppingPanel extends JPanel {
    private final double[] toppingsArr = {0.5,0.25,0.75,0.75};
    private final JCheckBox[] checkBoxes = new JCheckBox[4];

    public ToppingPanel() {
        super();
        super.setLayout(new GridLayout(4,1));
        this.checkBoxes[0] = new JCheckBox("Cream Cheese");
        this.checkBoxes[1] = new JCheckBox("Butter");
        this.checkBoxes[2] = new JCheckBox("Peach Jelly");
        this.checkBoxes[3] = new JCheckBox("Blueberry Jam");

        setBorder(BorderFactory.createTitledBorder("Toppings"));

        for(int i = 0; i < checkBoxes.length; i++)
            super.add(checkBoxes[i]);
    }
    public double toppingsCost() {
        double toppingsCost = 0.0;
        for(int i = 0; i < checkBoxes.length; i++) {
            if(checkBoxes[i].isSelected())
                toppingsCost += toppingsArr[i];
        }

        return toppingsCost;
    }

}
