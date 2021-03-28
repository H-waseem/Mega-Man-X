package game;

import gui.BGMSlider;
import gui.ButtonPanel;
import city.cs.engine.UserView;
import levels.*;

import javax.swing.*;
import java.awt.*;

public class Game {

    public static GameLevel level;
    private static GameView view;
    private static MegaManController megaManController;
    private static JFrame frame;
    private static UserView wideView;

    /** Initialise a new Game. */
    public Game() { //Level 1 initialised here

        // make the level
        level = new Level1(this);

        level.addStepListener(new WalkerBotAI(level.getWalkerBot()));
        level.addStepListener(new WalkerBotAI2(level.getWalkerBot2()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(level, 650, 720);

        // make a view
        view = new GameView(level, 1080, 720);
        view.setZoom(20);
        view.addMouseListener(new MouseHandler()); //  add some mouse actions add this to the view, so coordinates are relative to the view

        megaManController = new MegaManController(level.getMegaMan());
        view.addKeyListener(megaManController);

        //uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        MouseHandler mh = new MouseHandler();
        view.addMouseListener(mh);
        view.addMouseListener(new GiveFocus(view));
        level.addStepListener(new Tracker());

        frame = new JFrame("Mega Man X");


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        wideView = new UserView(level, 500, 150); // Wide view for the minimap below the game
        wideView.setZoom(3.7f); //have it zoomed out for map coverage

        frame.add(view); //add game view
        frame.add(wideView, BorderLayout.SOUTH); //add wide view at the bottom of the game

        ButtonPanel bp = new ButtonPanel(); //implement button panel

        frame.add(bp,BorderLayout.EAST);
        frame.add(BGMSlider.createSlider(), BorderLayout.WEST);


        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the level view
        frame.pack();
        //make the frame visible
        frame.setVisible(true);

        ButtonPanel.updateLevelText();
        level.start();// start the level

    }

    public void updateFrame(){ //updates the wide view for a new map
        wideView = new UserView(level, 500, 150);
        wideView.setZoom(3.7f);
        frame.remove(wideView);
        frame.add(wideView, BorderLayout.SOUTH);
        frame.pack();
    }

    public void removeCurrent(){ //Method for removing old level assets
        level.stop();
        frame.remove(wideView);
        frame.remove(view);
        GameLevel.gameMusic.stop();
    }
    public void addNew(){ //re update all music frames and views and also start level
        //uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        view.addKeyListener(megaManController);
        view.setZoom(20);
        view.addMouseListener(new MouseHandler()); //  add some mouse actions add this to the view, so coordinates are relative to the view
        view.addMouseListener(new GiveFocus(view));

        /* Level additions */
        level.addStepListener(new Tracker());
        frame.add(view);
        view.setWorld(level);

        megaManController.updateMegaMan(level.getMegaMan());

        updateFrame();
        level.start();
        ButtonPanel.updateLevelText();
    }

    public static void setLevel(int l) {

        level.stop();
        frame.remove(wideView);
        frame.remove(view);
        GameLevel.gameMusic.stop(); // Remove current

        if (l == 1) {
            level = new Level1(level.getGame());
        } else if (l == 2){
            level = new Level2(level.getGame());
        } else if (l == 3){
            level = new Level3(level.getGame());
        } else if (l == 4){
            level = new Level4(level.getGame());
        }else if (l == 5){
            level = new Level5(level.getGame());
        }

        view = new GameView(level, 1080, 720); //mid

        view.addKeyListener(megaManController);
        view.setZoom(20);
        view.addMouseListener(new MouseHandler()); //  add some mouse actions add this to the view, so coordinates are relative to the view
        view.addMouseListener(new GiveFocus(view));

        /* level additions*/
        level.addStepListener(new Tracker());
        frame.add(view);
        view.setWorld(level);
        megaManController.updateMegaMan(level.getMegaMan());

        wideView = new UserView(level, 500, 150);
        wideView.setZoom(3.7f);
        frame.remove(wideView);
        frame.add(wideView, BorderLayout.SOUTH);
        frame.pack();//update frame

        level.start();
        ButtonPanel.updateLevelText();
        System.out.println("Finished loading");
    }

    public void goToNextLevel() { //Re initialise all views,frames, controllers etc for each level when levels are completed

        if (level instanceof Level1) {
            /* Remove current */
            removeCurrent();

            /* Implement new */
            level = new Level2(level.getGame());
            view = new GameView(level, 1080, 720);

            /* View additions */
            addNew();
        }

        else if (level instanceof Level2) {
            /* Remove current */
            removeCurrent();

            /* Implement new */
            level = new Level3(level.getGame());
            view = new GameView(level, 1080, 720);

            /* View additions */
            addNew();
        }


        else if (level instanceof Level3) {
            /* Remove current */
            removeCurrent();

            /* Implement new */
            level = new Level4(level.getGame());
            view = new GameView(level, 1080, 720);

            /* View additions */
            addNew();
        }

        else if (level instanceof Level4) {
            /* Remove current */
            removeCurrent();

            /* Implement new */
            level = new Level5(level.getGame());
            view = new GameView(level, 1080, 720);

            /* View additions */
            addNew();

        }
        else if (level instanceof Level5) {
            System.out.println("|GAME COMPLETE!!!|");
            System.exit(0);
        }
    }
    public static GameLevel getLevel(){
        return level;
    }
    public static GameView getView(){return view;}

    public static JFrame getFrame(){
        return frame;
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game(); }
}


