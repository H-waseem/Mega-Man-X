package GUI;

import GUI.Actions.*;
import game.Game;
import levels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {


    private static JLabel l2 = new JLabel();

    public ButtonPanel() {
        this.setPreferredSize(new Dimension(200,500));

        JLabel l1 = new JLabel();


        l1.setText("Main GUI for level controlling");


        Icon icon = new ImageIcon("data/Button.png");

        JButton start = new JButton ("Start",icon);
        JButton pause = new JButton ("Pause",icon);
        JButton tutorial = new JButton ("Tutorial",icon);
        JButton quit = new JButton ("Quit",icon);

        start.setVerticalTextPosition(SwingConstants.TOP);
        start.setHorizontalTextPosition(SwingConstants.CENTER);

        pause.setVerticalTextPosition(SwingConstants.TOP);
        pause.setHorizontalTextPosition(SwingConstants.CENTER);

        tutorial.setVerticalTextPosition(SwingConstants.TOP);
        tutorial.setHorizontalTextPosition(SwingConstants.CENTER);

        quit.setVerticalTextPosition(SwingConstants.TOP);
        quit.setHorizontalTextPosition(SwingConstants.CENTER);

        add(l1);
        add(l2);

        start.addActionListener(new StartLevel());
        pause.addActionListener(new PauseLevel());
        tutorial.addActionListener(new Tutorial());
        quit.addActionListener(new QuitAction());


        add(start);
        add(pause);
        add(tutorial);
        add(quit);

    }

    public static void updateLevelText() {
        if (Game.getLevel() instanceof Level1) {
            l2.setText("Current level: 1 (Storm Eagle)");
        }
        if (Game.getLevel() instanceof Level2) {
            l2.setText("Current level: 2 (Storm Eagle Sky)");
        }
        if (Game.getLevel() instanceof Level3) {
            l2.setText("Current level: 3 (Flame Mammoth)");
        }
        if (Game.getLevel() instanceof Level4) {
            l2.setText("Current level: 4 (Boomer Kuwanger)");
        }
        if (Game.getLevel() instanceof Level5) {
            l2.setText("Current level: 5 (Chill Penguin)");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
