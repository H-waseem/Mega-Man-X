package gui.actions;

import game.Game;
import game.GameLevel;
import game.GameSaverLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Load implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            GameLevel level = GameSaverLoader.load(Game.getLevel(),"data/save.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
