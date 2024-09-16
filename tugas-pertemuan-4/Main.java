import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JLabel timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Sans-Serif", Font.BOLD, 48));  // Set font and size

        frame.add(timeLabel);

        ClockDisplay clock = new ClockDisplay();

        LocalTime currentTime = LocalTime.now();
        int currentHour = currentTime.getHour();
        int currentMinute = currentTime.getMinute();
        int currentSecond = currentTime.getSecond();

        clock.setTime(currentHour, currentMinute, currentSecond);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clock.timeTick();

                timeLabel.setText(clock.getTime());
            }
        });

        timer.start();

        frame.setVisible(true);
    }
}
