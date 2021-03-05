package Collision;

import bodies.MegaMan;
import bodies.Shot;
import bodies.WalkerBot;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


public class WalkerCollision implements CollisionListener {

    private final WalkerBot walkerBot;

    public WalkerCollision(WalkerBot w){
        this.walkerBot = w;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Shot) { // if the walker bot gets hit by a shot it loses HP and the shot is removed
            e.getOtherBody().destroy();
            walkerBot.setHp(walkerBot.getHp()-1);
            System.out.println("Walker HP: " + walkerBot.getHp());
        }
        if (e.getOtherBody() instanceof Shot && walkerBot.getHp() <= 0) { //Destroy walker bot if it gets hit by shot and is at ot below 0 HP
            MegaMan.setKills();
            walkerBot.destroy();
        }
    }
}
