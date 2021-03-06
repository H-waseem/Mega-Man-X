package GUI;

import city.cs.engine.SoundClip;
import levels.LevelBGMHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PauseButton extends JPanel implements ChangeListener {


    // Button
    public static JButton button;
    // label
    static JLabel label;
    //public static double volume;
    //private static JPanel mainPanel;

    public static PauseButton createButton() //Method to creating slider
    {
        // create a object
        PauseButton p = new PauseButton();
        // create label
        label = new JLabel();
        // create a panel
        //JPanel p = new JPanel();

        // create a slider
        button = new JButton();

        // setChangeListener
        button.addChangeListener(p);
        // set orientation of slider
        button.setAlignmentX(20);
        button.setText("Pause");

        label.setText("Pause");

        // add slider to panel
        p.add(button);
        p.add(label);


        // set the text of label
        //label.setText("BGM Volume = " + button.getValue());

        // set the size of frame
        p.setSize(300, 300);
        //f.show();
        return p;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
    }
}
