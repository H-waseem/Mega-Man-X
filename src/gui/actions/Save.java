package gui.actions;

import game.Game;
import game.GameSaverLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Save implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            GameSaverLoader.save(Game.getLevel(),"data/save.txt");
            System.out.println("Game Saved");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
