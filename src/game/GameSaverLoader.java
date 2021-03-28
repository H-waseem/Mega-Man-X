package game;

import bodies.MegaMan;
import levels.Level1;
import levels.Level2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    public static void save(GameLevel level, String fileName) throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(GameLevel.getLevelName(Game.getLevel()) + "," + MegaMan.getKills() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static GameLevel load(GameLevel level,String fileName) throws IOException { //Returns a GameLevel
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            int kills = Integer.parseInt(tokens[1]);


            switch (name) {
                case "Level1" -> {
                    System.out.println("Level 1");
                    Game.setLevel(1);
                }
                case "Level2" -> {
                    System.out.println("loading level 2");
                    Game.setLevel(2);
                }
                case "Level3" -> {
                    System.out.println("loading level 3");
                    Game.setLevel(3);
                }
                case "Level4" -> {
                    System.out.println("loading level 4");
                    Game.setLevel(4);
                }
                case "Level5" -> {
                    System.out.println("loading level 5");
                    Game.setLevel(5);
                }
            }

            MegaMan.loadKills(kills);

            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}



