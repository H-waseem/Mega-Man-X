package game;

import collision.PortalEncounter;
import bodies.ExitPortal;
import bodies.MegaMan;
import bodies.Rabbit;
import bodies.WalkerBot;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import levels.*;

public abstract class GameLevel extends World {

    public static SoundClip gameMusic;
    private final MegaMan megaMan;
    private final WalkerBot walkerBot;
    private static WalkerBot walkerBot2;
    private static Rabbit rabbit;
    private final ExitPortal exitPortal;
    private Game game;


    public GameLevel(Game game){
        megaMan = new MegaMan(this);
        walkerBot = new WalkerBot(this);
        exitPortal = new ExitPortal(this);

        PortalEncounter encounter = new PortalEncounter(this, game);
        megaMan.addCollisionListener(encounter);
        this.addStepListener(new WalkerBotAI(this.getWalkerBot()));
        this.addStepListener(new WalkerBotAI2(this.getWalkerBot2()));
        this.addStepListener(new RabbitAI(getRabbit()));

        this.game = game;
    }

    public static void setWalkerBot2(WalkerBot walkerBot2) {
        GameLevel.walkerBot2 = walkerBot2;
    }

    public static void setRabbit(Rabbit rabbit) {
        GameLevel.rabbit = rabbit;
    }

    public static String getLevelName(GameLevel level){
        if (level instanceof Level1){
            return "Level1";
        }
        if (level instanceof Level2){
            return "Level2";
        }
        if (level instanceof Level3){
            return "Level3";
        }
        if (level instanceof Level4){
            return "Level4";
        }
        if (level instanceof Level5){
            return "Level5";
        }
        return "";
    }

    public MegaMan getMegaMan(){
        return megaMan;
    }
    public WalkerBot getWalkerBot(){
        return walkerBot;
    }
    public WalkerBot getWalkerBot2(){return walkerBot2;}
    public Game getGame() {return game;}
    public static Rabbit getRabbit(){return rabbit;}
    public ExitPortal getExitPortal() {return exitPortal;}

    public abstract boolean isComplete();
}


