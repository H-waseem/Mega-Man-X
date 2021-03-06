package GUI.Actions;

import game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartLevel implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.getLevel().start(); //Make world start
        System.out.println("Game Started!");
    }
}