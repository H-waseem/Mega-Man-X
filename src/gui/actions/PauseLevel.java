package gui.actions;

import game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseLevel implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.getLevel().stop(); //Make world stop
        System.out.println("Game Paused!");
    }
}
