//BS'D
import javax.swing.*;
import java.awt.*;

public class BagelPanel extends JPanel {
    private final double WHEAT_BAGEL = 1.50;
    private final double WHITE_BAGEL = 1.25;
    private JRadioButton wheatButton;
    private JRadioButton whiteButton;
    private ButtonGroup group;

    public BagelPanel(){
        super();
        super.setLayout(new GridLayout(2,1));
        this.wheatButton = new JRadioButton("Wheat Bagel",true);
        this.whiteButton = new JRadioButton("White Bagel");

        setBorder(BorderFactory.createTitledBorder("Bagel"));

        this.group = new ButtonGroup();
        group.add(wheatButton);
        group.add(whiteButton);
        super.add(wheatButton);
        super.add(whiteButton);
    }

    public double bagelCost() {
        double bagelCost = 0.0;

        if(wheatButton.isSelected())
            bagelCost = WHEAT_BAGEL;
        else if (whiteButton.isSelected())
            bagelCost = WHITE_BAGEL;

        return bagelCost;
    }
}
