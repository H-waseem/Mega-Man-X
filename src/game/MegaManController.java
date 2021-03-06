package game;

import Collision.ShotCollision;
import bodies.MegaMan;
import bodies.Shot;
import city.cs.engine.BodyImage;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MegaManController implements KeyListener {

    private static final float WALKING_SPEED = 15; //Standard walking speed

    private MegaMan megaMan; //Declare Mega man as final

    private static int boost = 3; //Number of boosts

    private Boolean facingRight = true; //A boolean used to determine if the player is facing right or left

    private static SoundClip shotSound;
    private static SoundClip jumpSound;

    public MegaManController(MegaMan m){
        megaMan = m;
    }

    static {
        try {
            shotSound = new SoundClip("data/Shot sound.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }

    static {
        try {
            jumpSound = new SoundClip("data/Jump sound.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }

    // Below are the images of MegaMan and its projectiles________
    private static final BodyImage MegaManStandRight =
            new BodyImage("data/XRight.png", 5f);

    private static final BodyImage MegaManStandLeft =
            new BodyImage("data/XLeft.png", 5f);

    private static final BodyImage MegaManRight =
            new BodyImage("data/XWalkRight.gif", 5f);

    private static final BodyImage MegaManLeft =
            new BodyImage("data/XWalkLeft.gif", 5f);

    private static final BodyImage shot3Right =
            new BodyImage("data/shot3Right.gif", 5f);

    private static final BodyImage shot3Left =
            new BodyImage("data/shot3Left.gif", 5f);
    //_______________________________________________________________

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //Gets last pressed key

        if (code == KeyEvent.VK_D) { //Walk right if D is pressed and change corresponding values
            megaMan.startWalking(WALKING_SPEED);
            megaMan.removeAllImages();
            megaMan.addImage(MegaManRight);
            facingRight = true;

        } if (code == KeyEvent.VK_A) { //Walk left if A is pressed and change corresponding values
            megaMan.startWalking(-WALKING_SPEED);
            megaMan.removeAllImages();
            megaMan.addImage(MegaManLeft);
            facingRight = false;

        } if (code == KeyEvent.VK_SHIFT && facingRight && boost > 0) { // Dash/boost Right if J is pressed and facing right and if Boost isn't empty
            megaMan.startWalking(WALKING_SPEED*2f);
            boost--;

        } if (code == KeyEvent.VK_SHIFT && !facingRight && boost > 0) { // Dash/boost left if J is pressed and facing left and if Boost isn't empty
            megaMan.startWalking(-WALKING_SPEED*2f);
            boost--;
        }

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE) { // Jump if W or space-bar is pressed
            jumpSound.stop();
            megaMan.jump(45f); //Jump
            jumpSound.play();
        }

        if (code == KeyEvent.VK_K && facingRight) { //Shoot right if K is pressed and facing right
            shotSound.stop();
            Vec2 selfPoint = megaMan.getPosition().add(new Vec2(3.6f, 0)); //Position projectile right out of megaman's hitbox
            Shot shot = new Shot(megaMan.getWorld()); //Create new instance of shot
            shot.addImage(shot3Right); //Add image of right shot
            shot.setPosition(selfPoint); //position projectile on co ords
            shot.setLinearVelocity(new Vec2(40, 0)); // Give the shot some speed
            ShotCollision shotCollision = new ShotCollision(shot); //Adds wall collision
            shot.addCollisionListener(shotCollision); //Wall collision listener
            shotSound.play();

        } if (code == KeyEvent.VK_K && !facingRight){ //Shoot left if K is pressed and facing left
            shotSound.stop();
            Vec2 selfPoint = megaMan.getPosition().add(new Vec2(-3.6f,0)); //Position projectile left out of megaman's hitbox
            Shot shot = new Shot(megaMan.getWorld()); //Create new instance of shot
            shot.addImage(shot3Left); //Add image of left shot
            shot.setPosition(selfPoint); //position projectile on co ords
            shot.setLinearVelocity(new Vec2(-40,0)); // Give the shot some speed
            ShotCollision shotCollision = new ShotCollision(shot); //Adds wall collision
            shot.addCollisionListener(shotCollision); //Wall collision listener
            shotSound.play();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {//Stop moving right after button is no longer pressed
            megaMan.stopWalking();
            megaMan.removeAllImages();
            megaMan.addImage(MegaManStandRight);

        } if (code == KeyEvent.VK_A) { //Stop moving left after button is no longer pressed
            megaMan.stopWalking();
            megaMan.removeAllImages();
            megaMan.addImage(MegaManStandLeft);

        } if (code == KeyEvent.VK_SHIFT && boost > 0) { //Stop boosting after shift is no longer pressed and boost is not empty
            megaMan.stopWalking();
        }
    }
    public void updateMegaMan(MegaMan megaMan) { this.megaMan = megaMan;}

    public static int getBoost() {
        return boost;
    }
}
