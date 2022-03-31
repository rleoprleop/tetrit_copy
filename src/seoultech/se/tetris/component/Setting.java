package seoultech.se.tetris.component;

import seoultech.se.tetris.component.setting.DisplaySetting;
import seoultech.se.tetris.component.setting.KeySetting;
import seoultech.se.tetris.component.setting.LevelSetting;

import javax.swing.*;
import javax.swing.text.BoxView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class Setting extends JFrame {
    private Container container;
    private JPanel backButtonPanel, menuPanel;
    private JButton backButton;
    private JButton level, colorWeak, display, keySetting, reset;

    public Setting(int x, int y) {
        this.setSize(500, 600);
        this.setLocation(x, y);
        this.setLayout(new BorderLayout(25, 25));

        setbackButtonPanel();
        setMenuPanel();

        this.add(backButtonPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void setbackButtonPanel() {
        backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("back");

        backButton.addActionListener(listner);
        backButtonPanel.add(backButton);
    }

    private void setMenuPanel() {
        menuPanel = new JPanel(new GridLayout(5, 1, 5, 0));

        JPanel levelPanel = new JPanel();
        level = new JButton("Level");
        level.setPreferredSize(new Dimension(180, 60));
        level.addActionListener(listner);
        levelPanel.add(level);

        JPanel colorWeakPanel = new JPanel();
        colorWeak = new JButton("Color_Weak");
        colorWeak.setPreferredSize(new Dimension(180, 60));
        colorWeak.addActionListener(listner);
        colorWeakPanel.add(colorWeak);

        JPanel displayPanel = new JPanel();
        display = new JButton("Display");
        display.setPreferredSize(new Dimension(180, 60));
        display.addActionListener(listner);
        displayPanel.add(display);

        JPanel keySettingPanel = new JPanel();
        keySetting = new JButton("KeySetting");
        keySetting.setPreferredSize(new Dimension(180, 60));
        keySetting.addActionListener(listner);
        keySettingPanel.add(keySetting);

        JPanel resetPanel = new JPanel();
        reset = new JButton("Reset");
        reset.setPreferredSize(new Dimension(180, 60));
        reset.addActionListener(listner);
        resetPanel.add(reset);

        menuPanel.add(levelPanel);
        menuPanel.add(colorWeakPanel);
        menuPanel.add(displayPanel);
        menuPanel.add(keySettingPanel);
        menuPanel.add(resetPanel);
    }

    ActionListener listner = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (backButton.equals(e.getSource())) { //terminateButton pressed
                new TetrisMenu(getThis().getLocation().x, getThis().getLocation().y);
                getThis().dispose();
            }
            else if (level.equals(e.getSource())) { // restartButton pressed
                new LevelSetting(getThis().getLocation().x, getThis().getLocation().y);
                getThis().dispose();
            }
            else if (colorWeak.equals(e.getSource())) { // restartButton pressed

            }
            else if (display.equals(e.getSource())) { // restartButton pressed
                new DisplaySetting(getThis().getLocation().x, getThis().getLocation().y);
                getThis().dispose();
            }
            else if (keySetting.equals(e.getSource())) { // restartButton pressed
                new KeySetting(getThis().getLocation().x, getThis().getLocation().y);
                getThis().dispose();
            }
            else { // restartButton pressed

            }
        }
    };

    private JFrame getThis() {return this;}



}
