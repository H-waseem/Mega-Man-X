package game;

import Collision.PortalEncounter;
import bodies.ExitPortal;
import bodies.MegaMan;
import bodies.WalkerBot;
import city.cs.engine.SoundClip;
import city.cs.engine.World;

public abstract class GameLevel extends World {

    public static SoundClip gameMusic;
    private MegaMan megaMan;
    private WalkerBot walkerBot;
    private ExitPortal exitPortal;


    public GameLevel(Game game){
        megaMan = new MegaMan(this);
        walkerBot = new WalkerBot(this);
        exitPortal = new ExitPortal(this);
        PortalEncounter encounter = new PortalEncounter(this, game);
        megaMan.addCollisionListener(encounter);
    }

    public MegaMan getMegaMan(){
        return megaMan;
    }
    public WalkerBot getWalkerBot(){
        return walkerBot;
    }
    public ExitPortal getExitPortal() {return exitPortal;}
    public SoundClip getGameMusic(){return gameMusic;}
    public abstract boolean isComplete();
}


