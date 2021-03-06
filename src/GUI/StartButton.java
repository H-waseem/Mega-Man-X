package GUI;

import city.cs.engine.SoundClip;
import levels.LevelBGMHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StartButton extends JPanel implements ChangeListener {


    // Button
    public static JButton button;
    // label
    static JLabel label;
    //public static double volume;
    //private static JPanel mainPanel;

    public static StartButton createButton() //Method to creating slider
    {
        // create a object
        StartButton s = new StartButton();
        // create label
        label = new JLabel();
        // create a panel
        //JPanel p = new JPanel();

        // create a slider
        button = new JButton();

        // setChangeListener
        button.addChangeListener(s);
        // set orientation of slider
        button.setAlignmentX(20);
        button.setText("Start");

        label.setText("Start");

        // add slider to panel
        s.add(button);
        s.add(label);

        // set the text of label
        //label.setText("BGM Volume = " + button.getValue());

        // set the size of frame
        s.setSize(300, 300);
        //f.show();
        return s;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
    }
}