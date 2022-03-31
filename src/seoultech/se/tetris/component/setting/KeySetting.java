package seoultech.se.tetris.component.setting;

import javax.swing.*;
import java.awt.*;

public class KeySetting extends JFrame {
    private Container container;
    private JPanel backButtonPanel, menuPanel;
    private JButton backButton;
    private JButton level, colorWeak, display, keySetting, reset;

    public void LevelSetting(int x, int y) {
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
    private void setbackButtonPanel(){
        backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("back");
        backButtonPanel.add(backButton);
    }

    private void setMenuPanel(){
        menuPanel = new JPanel(new GridLayout(5,1,5,0));

        JPanel levelPanel = new JPanel();
        level = new JButton("Level");
        level.setPreferredSize(new Dimension(180, 60));
        levelPanel.add(level);

        JPanel colorWeakPanel = new JPanel();
        colorWeak = new JButton("Color_Weak");
        colorWeak.setPreferredSize(new Dimension(180, 60));
        colorWeakPanel.add(colorWeak);

        JPanel displayPanel  = new JPanel();
        display = new JButton("Display");
        display.setPreferredSize(new Dimension(180, 60));
        displayPanel.add(display);

        JPanel keySettingPanel  = new JPanel();
        keySetting = new JButton("KeySetting");
        keySetting.setPreferredSize(new Dimension(180, 60));
        keySettingPanel.add(keySetting);

        JPanel resetPanel  = new JPanel();
        reset = new JButton("Reset");
        reset.setPreferredSize(new Dimension(180, 60));
        resetPanel.add(reset);

        menuPanel.add(levelPanel);
        menuPanel.add(colorWeakPanel);
        menuPanel.add(displayPanel);
        menuPanel.add(keySettingPanel);
        menuPanel.add(resetPanel);
    }


}
