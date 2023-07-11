//BS'D
/*
A long-distance provider charges the following rates for telephone calls:
Rate Category Rate per Minute
Daytime (6:00 a.m. through 5:59 p.m.) $0.07
Evening (6:00 p.m. through 11:59 p.m.) $0.12
Off-Peak (12:00 a.m. through 5:59 a.m.) $0.05
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LongDistanceCalls extends JFrame {
    private JPanel panel;
    private JButton startStopCall;
    private JLabel timeLabel;
    private int elapsedTime;
    private int seconds;
    private int minutes;
    private int hours;
    private boolean started;
    private String stringSeconds;
    private String stringMinutes;
    private String stringHours;
    private Timer timer;

    private JRadioButton daytimeButton;
    private JRadioButton eveningButton;
    private JRadioButton offpeakButton;
    private ButtonGroup group;

    public LongDistanceCalls(){
        super();
        super.setTitle("Long Distance Calls");
        super.setSize(650,500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTimer();
        setButtons();
        super.add(panel);
        super.pack();
        super.setVisible(true);
    }

    public void setTimer() {
        this.panel = new JPanel(new GridLayout(5,1));

        this.elapsedTime = 0;
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
        this.stringSeconds = String.format("%02d",seconds);
        this.stringMinutes = String.format("%02d",minutes);
        this.stringHours = String.format("%02d",hours);
        this.timeLabel = new JLabel(stringHours+":"+stringMinutes+":"+stringSeconds);

        this.timer = new Timer(1000, new TimerActionListener());
        this.startStopCall = new JButton("START");
        startStopCall.addActionListener(new StartStopListener());

        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        panel.add(timeLabel);
        panel.add(startStopCall);

    }

    private class TimerActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
                elapsedTime = elapsedTime + 1000;
                hours = (elapsedTime / 3600000);
                minutes = (elapsedTime / 60000) % 60;
                seconds = (elapsedTime / 1000) % 60;
                stringSeconds = String.format("%02d", seconds);
                stringMinutes = String.format("%02d", minutes);
                stringHours = String.format("%02d", hours);
                timeLabel.setText(stringHours + ":" + stringMinutes + ":" + stringSeconds);
        }
    }

    public void setButtons() {
        this.daytimeButton = new JRadioButton("Daytime (6:00 a.m. through 5:59 p.m.) $0.07/min",true);
        this.eveningButton = new JRadioButton("Evening (6:00 p.m. through 11:59 p.m.) $0.12/min");
        this.offpeakButton = new JRadioButton("Off-Peak (12:00 a.m. through 5:59 a.m.) $0.05/min");
        this.group = new ButtonGroup();
        group.add(daytimeButton);
        group.add(eveningButton);
        group.add(offpeakButton);
        panel.add(daytimeButton);
        panel.add(eveningButton);
        panel.add(offpeakButton);
    }

    private class StartStopListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == startStopCall) {
                double total = 0.0;
                if(started == false) {
                    started = true;
                    startStopCall.setText("STOP");
                    timer.start();
                }
                else {
                    started = false;
                    startStopCall.setText("START");
                    timer.stop();
                    if(daytimeButton.isSelected()) {
                        total = ((hours * 60) + minutes) * .07;
                    }
                    else if(eveningButton.isSelected()){
                        total = ((hours*60) + minutes) * 0.12;
                    }
                    else if(offpeakButton.isSelected()){
                        total = ((hours*60) + minutes) * 0.05;
                    }
                    elapsedTime = 0;
                    seconds = 0;
                    minutes = 0;
                    hours = 0;
                    stringSeconds = String.format("%02d",seconds);
                    stringMinutes = String.format("%02d",minutes);
                    stringHours = String.format("%02d",hours);
                    timeLabel.setText(stringHours + ":" + stringMinutes + ":" + stringSeconds);

                    JOptionPane.showMessageDialog(null,"Total charges:" + total);
                    total = 0.0;
                }

            }
        }
    }

    public static void main(String[] args) {
        new LongDistanceCalls();
    }
}
