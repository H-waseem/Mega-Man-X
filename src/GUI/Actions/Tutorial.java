package GUI.Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("");
        System.out.println("      |<Welcome to the Mega Man X >|");
        System.out.println("___________________________________________________________________");
        System.out.println("* Press A and D to move left and right                            *");
        System.out.println("* Press W or SPACE to jump                                        *");
        System.out.println("* Press LShift to use a Boost/Dash (Only 3 uses)                  *");
        System.out.println("* Press K to shoot                                                *");
        System.out.println("* Reach the exit portal after killing all bots to progress levels *");
        System.out.println("* Getting hit by a missile or colliding into bots removes HP      *");
        System.out.println("* Shooting the bots eliminates them                               *");
        System.out.println("* Adjust Background music volume using slider on left             *");
        System.out.println("* Pause, Start, and quit the game using buttons on right          *");
        System.out.println("* Completing Level 5 finishes the Game                            *");
        System.out.println("___________________________________________________________________");

    }
}
