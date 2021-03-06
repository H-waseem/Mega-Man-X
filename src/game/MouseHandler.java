package game;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {

    public MouseHandler(){
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //when mouse is pressed create a missile at the cursor
        //Missile missile = new Missile(level); //Create new missile instance
        //Point mousePoint = e.getPoint(); // Get mouse co ords
        //Vec2 worldPoint = view.viewToWorld(mousePoint); // Translate to world co ords
        //missile.setPosition(worldPoint); //Position missiles
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
