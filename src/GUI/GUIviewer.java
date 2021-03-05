package GUI;

import bodies.MegaMan;
import game.Game;

import javax.swing.*;
import java.awt.*;

public class GUIviewer {

    private Game game;

    public GUIviewer(){
        JFrame window = new JFrame("Main Menu");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // default layout manager is BorderLayout

        ViewPanel panel = new ViewPanel();
        window.add(panel, BorderLayout.CENTER);

        JLabel versionLabel = new JLabel();
        window.add(versionLabel, BorderLayout.SOUTH);

        //window.add(window, BorderLayout.WEST);

        window.pack();
        window.setVisible(true);
    }
    public static void main(String args[]) {
        new GUIviewer();
    }
}
