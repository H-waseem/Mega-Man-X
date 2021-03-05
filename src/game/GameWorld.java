package game;

import Collision.HPCollision;
import Collision.WalkerCollision;
import bodies.MegaMan;
import bodies.WalkerBot;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private final bodies.MegaMan MegaMan;

    private final bodies.WalkerBot WalkerBot;

    private final WalkerBot WalkerBot2;

    public GameWorld(){

       MegaMan = new MegaMan(this); //Create Mega man instance
       MegaMan.setPosition(new Vec2(8, -10));
       HPCollision xCollision = new HPCollision(MegaMan);
       MegaMan.addCollisionListener(xCollision);

       WalkerBot = new WalkerBot(this); //Create walker instance
       WalkerBot.setPosition(new Vec2(0,-10));
       WalkerCollision walkerCollision = new WalkerCollision(WalkerBot);
       WalkerBot.addCollisionListener(walkerCollision);

       WalkerBot2 = new WalkerBot(this); //Create walker instance
       WalkerBot2.setPosition(new Vec2(-15,0));
       WalkerCollision walkerCollision2 = new WalkerCollision(WalkerBot2);
       WalkerBot2.addCollisionListener(walkerCollision2);


    }

    public MegaMan getMegaMan(){
        return MegaMan;
    }

    public WalkerBot getWalkerBot(){
        return WalkerBot;
    }

}
