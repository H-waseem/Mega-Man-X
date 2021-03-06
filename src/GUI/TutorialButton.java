package GUI;

import city.cs.engine.SoundClip;
import levels.LevelBGMHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TutorialButton extends JPanel implements ChangeListener {


    // Button
    public static JButton button;
    // label
    static JLabel label;
    //public static double volume;
    //private static JPanel mainPanel;

    public static TutorialButton createButton() //Method to creating slider
    {
        // create a object
        TutorialButton t = new TutorialButton();
        // create label
        label = new JLabel();
        // create a panel
        //JPanel p = new JPanel();

        // create a slider
        button = new JButton();

        // setChangeListener
        button.addChangeListener(t);
        // set orientation of slider
        button.setAlignmentX(20);
        button.setText("Pause");

        label.setText("Pause");

        // add slider to panel
        t.add(button);
        t.add(label);


        // set the text of label
        //label.setText("BGM Volume = " + button.getValue());

        // set the size of frame
        t.setSize(300, 300);
        //f.show();
        return t;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
    }
}
