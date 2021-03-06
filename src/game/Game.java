package game;

import GUI.BGMSlider;
import GUI.ButtonPanel;
import GUI.PauseButton;
import GUI.StartButton;
import city.cs.engine.DebugViewer;
import city.cs.engine.UserView;
import levels.*;

import javax.swing.*;
import java.awt.*;



/*
        MAIN:
        [X] 2x new levels (subclass of common class)
        [X] player progression through levels
        [X] significant differences between levels
        [X] 4x interactive dynamic body (including bodies from M1)
        [X] background sound track
        [X] sound in response to an event
        [X] sounds load efficiently
        [X] GUI that displays at least 2x player info (e.g. health, score)
        [X] GUI controls (e.g. pause, restart)
        [X] encapsulation rules
        [X] naming conventions
        [X] well commented code
        [X] exception handling

        EXTRA:
        [X] manipulate levels by data / automatic level generation
        [X] more than 3 levels
        [X] innovative game behaviour
        [X] sophisticated bodies (e.g. ghostly bodies, collision filtering, storing bodies)
        [X] different body behaviour (e.g. angular rotation, change in size, change in movement)
        [X] different interactions between bodies (e.g. non-player bodies interact with each other)
        [X] sound controlled by GUI
        [X] background tracks change between levels
        [X] use of many sounds in response to events
        [X] keep player stats between levels (e.g. health) instead of resetting
        [X] display different GUI properties in different levels
        [X] custom GUI buttons
        [X] GUI components placed manually instead of using IntelliJ GUI editor
        [X] using different layout managers
        [X] use extra components (e.g. text boxes, drop downs)
        [X] more GUI functionality (e.g. change levels, control sound) */

public class Game {

    public static GameLevel level;
    private static GameView view;
    private MegaManController megaManController;
    private static JFrame frame;
    private UserView wideView;

    /** Initialise a new Game. */
    public Game() {

        // make the world
        //GameWorld world = new GameWorld();

        level = new Level1(this);

        level.addStepListener(new WalkerBotAI(level.getWalkerBot()));
        level.addStepListener(new WalkerBotAI2(level.getWalkerBot2()));
        //level.addStepListener(new RabbitAI(level.getRabbit()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(level, 650, 720);

        // make a view
        view = new GameView(level, 1080, 720);
        view.setZoom(20);
        view.addMouseListener(new MouseHandler(level, view)); //  add some mouse actions add this to the view, so coordinates are relative to the view

        megaManController = new MegaManController(level.getMegaMan());
        view.addKeyListener(megaManController);

        //uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        MouseHandler mh = new MouseHandler(level, view);
        view.addMouseListener(mh);
        view.addMouseListener(new GiveFocus(view));
        level.addStepListener(new Tracker());

        frame = new JFrame("Mega Man X");

        /* BUTTONS AND SLIDER */
        //frame.add(frame, BorderLayout.WEST);


        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        wideView = new UserView(level, 500, 150);
        wideView.setZoom(3.7f);

        frame.add(wideView, BorderLayout.SOUTH);

        ButtonPanel gp = new ButtonPanel();

        frame.add(gp,BorderLayout.EAST);
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

    public void updateFrame(){
        wideView = new UserView(level, 500, 150);
        wideView.setZoom(3.7f);
        frame.remove(wideView);
        frame.add(wideView, BorderLayout.SOUTH);
        frame.pack();
    }

    public void goToNextLevel() {
        // Learn switch cases
        if (level instanceof Level1) {
            /* Remove current */
            level.stop();
            frame.remove(wideView);
            frame.remove(view);
            GameLevel.gameMusic.stop();

            /* Implement new */
            level = new Level2(this);
            view = new GameView(level, 1080, 720);

            /* View additions */

            //uncomment this to draw a 1-metre grid over the view
            //view.setGridResolution(1);

            view.addKeyListener(megaManController);
            view.setZoom(20);
            view.addMouseListener(new MouseHandler(level, view)); //  add some mouse actions add this to the view, so coordinates are relative to the view
            view.addMouseListener(new GiveFocus(view));

            /* Level additions */
            level.addStepListener(new Tracker());
            frame.add(view);
            view.setWorld(level);

            megaManController.updateMegaMan(level.getMegaMan());

            updateFrame();
            level.start();
            ButtonPanel.updateLevelText();
            System.out.println(level);
        }

        else if (level instanceof Level2) {
            level.stop();
            frame.remove(wideView);
            frame.remove(view);
            GameLevel.gameMusic.stop();

            /* Implement new */
            level = new Level3(this);
            view = new GameView(level, 1080, 720);

            /* View additions */

            //uncomment this to draw a 1-metre grid over the view
            //view.setGridResolution(1);

            view.addKeyListener(megaManController);
            view.setZoom(20);
            view.addMouseListener(new MouseHandler(level, view)); //  add some mouse actions add this to the view, so coordinates are relative to the viewd
            view.addMouseListener(new GiveFocus(view));

            /* Level additions */
            level.addStepListener(new Tracker());
            frame.add(view);
            view.setWorld(level);

            megaManController.updateMegaMan(level.getMegaMan());


            wideView = new UserView(level, 500, 150);
            wideView.setZoom(2.7f);
            frame.remove(wideView);
            frame.add(wideView, BorderLayout.SOUTH);
            frame.pack();
            level.start();
            ButtonPanel.updateLevelText();
            System.out.println(level);
        }


        else if (level instanceof Level3) {
            level.stop();
            frame.remove(wideView);
            frame.remove(view);
            GameLevel.gameMusic.stop();

            /* Implement new */
            level = new Level4(this);
            view = new GameView(level, 1080, 720);

            /* View additions */

            //uncomment this to draw a 1-metre grid over the view
            //view.setGridResolution(1);

            view.addKeyListener(megaManController);
            view.setZoom(20);
            view.addMouseListener(new MouseHandler(level, view)); //  add some mouse actions add this to the view, so coordinates are relative to the viewd
            view.addMouseListener(new GiveFocus(view));

            /* Level additions */
            level.addStepListener(new Tracker());
            frame.add(view);
            view.setWorld(level);

            megaManController.updateMegaMan(level.getMegaMan());
            updateFrame();
            level.start();
            ButtonPanel.updateLevelText();
            System.out.println(level);
        }

        else if (level instanceof Level4) {
            level.stop();
            frame.remove(wideView);
            frame.remove(view);
            GameLevel.gameMusic.stop();

            /* Implement new */
            level = new Level5(this);
            view = new GameView(level, 1080, 720);

            /* View additions */

            //uncomment this to draw a 1-metre grid over the view
            //view.setGridResolution(1);
            view.addKeyListener(megaManController);
            view.setZoom(20);
            view.addMouseListener(new MouseHandler(level, view)); //  add some mouse actions add this to the view, so coordinates are relative to the viewd
            view.addMouseListener(new GiveFocus(view));

            /* Level additions */
            level.addStepListener(new Tracker());
            frame.add(view);
            view.setWorld(level);

            megaManController.updateMegaMan(level.getMegaMan());
            updateFrame();
            level.start();
            ButtonPanel.updateLevelText();
            System.out.println(level);

        }
        else if (level instanceof Level5) {
            System.out.println("Well done! Game complete.");
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

    public static void setLevel(GameLevel level) {
        Game.level = level;
    }

    /** Run the game. */
    public static void main(String[] args) { new Game();
        System.out.println(level);}
}


