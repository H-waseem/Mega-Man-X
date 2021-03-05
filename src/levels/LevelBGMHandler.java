package levels;


import city.cs.engine.SoundClip;
import game.Game;
import game.GameLevel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import static game.GameLevel.gameMusic;

public class LevelBGMHandler {


    public LevelBGMHandler() {

        GameLevel level = Game.getLevel();

         if (level instanceof Level1) {
            try {
                gameMusic = new SoundClip("data/Storm Eagle BGM.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
                System.out.println(level + "Playing storm");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
         }

        else if (level instanceof Level2) {
            try {
                gameMusic = new SoundClip("data/Flame Mammoth BGM.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
                System.out.println(level + "Playing flame");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }

        else if (level instanceof Level3) {
            try {
                gameMusic = new SoundClip("data/Boomer Kuwanger BGM.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }

        else if (level instanceof Level4) {
            try {
                gameMusic = new SoundClip("data/Chill Penguin BGM.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
    }
}
