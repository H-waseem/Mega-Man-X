package game;

import Collision.PortalEncounter;
import bodies.ExitPortal;
import bodies.MegaMan;
import bodies.Rabbit;
import bodies.WalkerBot;
import city.cs.engine.SoundClip;
import city.cs.engine.World;

public abstract class GameLevel extends World {

    public static SoundClip gameMusic;
    private final MegaMan megaMan;
    private final WalkerBot walkerBot;
    private static WalkerBot walkerBot2;
    private static Rabbit rabbit;
    private final ExitPortal exitPortal;


    public GameLevel(Game game){
        megaMan = new MegaMan(this);
        walkerBot = new WalkerBot(this);
        exitPortal = new ExitPortal(this);

        PortalEncounter encounter = new PortalEncounter(this, game);
        megaMan.addCollisionListener(encounter);
        this.addStepListener(new WalkerBotAI(this.getWalkerBot()));
        this.addStepListener(new WalkerBotAI2(this.getWalkerBot2()));
        this.addStepListener(new RabbitAI(getRabbit()));

    }

    public static void setWalkerBot2(WalkerBot walkerBot2) {
        GameLevel.walkerBot2 = walkerBot2;
    }

    public static void setRabbit(Rabbit rabbit) {
        GameLevel.rabbit = rabbit;
    }

    public MegaMan getMegaMan(){
        return megaMan;
    }
    public WalkerBot getWalkerBot(){
        return walkerBot;
    }
    public WalkerBot getWalkerBot2(){return walkerBot2;}
    public static Rabbit getRabbit(){return rabbit;}
    public ExitPortal getExitPortal() {return exitPortal;}

    public abstract boolean isComplete();
}


