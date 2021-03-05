package GUI;

import city.cs.engine.SoundClip;
import game.GameLevel;
import levels.LevelBGMHandler;
import javax.swing.event.*;

import javax.swing.*;

public class BGMSlider extends JPanel implements ChangeListener {

    // slider
    public static JSlider slider;
    // label
    static JLabel label;
    public static double volume;
    private static JPanel mainPanel;

    //private GameLevel level = Game.;
    private static SoundClip gameMusic;

    public static BGMSlider createSlider() //Method to creating slider
    {
        new LevelBGMHandler();
        // create a object
        BGMSlider s = new BGMSlider();
        // create label
        label = new JLabel();
        // create a panel
        //JPanel p = new JPanel();

        // create a slider
        slider = new JSlider(0, 100, 50);
        // paint the ticks and tracks
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        // set spacing
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(5);
        // setChangeListener
        slider.addChangeListener(s);
        // set orientation of slider
        slider.setOrientation(SwingConstants.VERTICAL);
        // add slider to panel
        s.add(slider);
        s.add(label);

        // set the text of label
        label.setText("BGM Volume = " + slider.getValue());

        // set the size of frame
        s.setSize(300, 300);
        //f.show();
        return s;
    }
    // if JSlider value is changed
    public void stateChanged(ChangeEvent e)
    {
        label.setText("BGM Volume = " + slider.getValue());
        //System.out.println(getVolume());
        GameLevel.gameMusic.setVolume(getVolume());
    }

    public static Double getVolume() {
        double temp = slider.getValue();
        if (temp>0) {
            volume = temp / 100;
        }
        else volume = 0.0001;

        return volume;
    }
    public static JPanel getMainPanel(){return mainPanel;}
}
