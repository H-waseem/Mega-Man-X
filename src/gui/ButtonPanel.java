package gui;

import gui.actions.*;
import game.Game;
import levels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {


    private static final JLabel l2 = new JLabel();

    public ButtonPanel() {
        this.setPreferredSize(new Dimension(200,500));

        JLabel l1 = new JLabel();


        l1.setText("Main GUI for level controlling");


        Icon st = new ImageIcon("data/Start.png");
        Icon ps = new ImageIcon("data/Pause.png");
        Icon sv = new ImageIcon("data/Save.png");
        Icon ld = new ImageIcon("data/Load.png");
        Icon tt = new ImageIcon("data/Tutorial.png");
        Icon qt = new ImageIcon("data/Quit.png");

        JButton start = new JButton (st);
        JButton pause = new JButton (ps);
        JButton save = new JButton (sv);
        JButton load = new JButton (ld);
        JButton tutorial = new JButton (tt);
        JButton quit = new JButton (qt);

        add(l1);
        add(l2);

        start.addActionListener(new StartLevel());
        pause.addActionListener(new PauseLevel());
        save.addActionListener(new Save());
        load.addActionListener(new Load());
        tutorial.addActionListener(new Tutorial());
        quit.addActionListener(new QuitAction());

        add(start);
        add(pause);
        add(save);
        add(load);
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
