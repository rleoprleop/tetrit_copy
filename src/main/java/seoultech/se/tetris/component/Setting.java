package seoultech.se.tetris.component;

import seoultech.se.tetris.component.model.Data;
import seoultech.se.tetris.component.setting.DisplaySetting;
import seoultech.se.tetris.component.setting.KeySetting;
import seoultech.se.tetris.component.setting.LevelSetting;

import javax.swing.*;
import javax.swing.text.BoxView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Setting extends JFrame {
    private Container container;
    private JPanel backButtonPanel, menuPanel;
    private JButton backButton;
    private JButton level, colorWeak, display, keySetting, reset;
    private Data settingdata;
    private ImageIcon background = new ImageIcon("img/Background.png");

    public Setting(int x, int y) {

        JPanel back = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(background.getImage(),0,0,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        this.setFocusable(true);
        this.setSize(510, 635);
        this.setLocation(x, y);

        //test
        JPanel testpn = new JPanel();
        JButton testbt = new JButton("back");
        testpn.setLayout(null);
        testpn.setOpaque(false);
        testbt.setSize(100,60);
        testbt.setOpaque(false);
        testbt.setBounds(10,10,100,50);
        testpn.add(testbt);
        this.add(testpn);







        setbackButtonPanel();
        setMenuPanel();

        //this.add(backButtonPanel);
        //back.add(menuPanel, BorderLayout.CENTER);
        this.getContentPane().add(back);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void setbackButtonPanel() {
        backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("back");
        backButtonPanel.setBounds(10,10,backButton.getWidth(),backButton.getHeight());
        backButtonPanel.setOpaque(false);

        backButton.addActionListener(listner);
        backButtonPanel.add(backButton);
    }

    private Image changeImgSize(String path){
        ImageIcon img = new ImageIcon(path);
        Image img1 = img.getImage();
        Image changeImg = img1.getScaledInstance(180,60, Image.SCALE_SMOOTH);
        return changeImg;
    }

    private void setMenuPanel() {
        menuPanel = new JPanel(new GridLayout(5, 1, 5, 0));
        ImageIcon level_activate = new ImageIcon(changeImgSize("img/settingMenu/Level_activate.png"));
        ImageIcon level_disabled = new ImageIcon(changeImgSize("img/settingMenu/Level_disabled.png"));
        ImageIcon colorweak_activate = new ImageIcon(changeImgSize("img/settingMenu/Colorweak_activate.png"));
        ImageIcon colorweak_disabled = new ImageIcon(changeImgSize("img/settingMenu/Colorweak_disabled.png"));
        ImageIcon display_activate = new ImageIcon(changeImgSize("img/settingMenu/Display_activate.png"));
        ImageIcon display_disabled = new ImageIcon(changeImgSize("img/settingMenu/Display_disabled.png"));
        ImageIcon keymapping_activate = new ImageIcon(changeImgSize("img/settingMenu/Keymapping_activate.png"));
        ImageIcon keymapping_disabled = new ImageIcon(changeImgSize("img/settingMenu/Keymapping_disabled.png"));
        ImageIcon reset_activate = new ImageIcon(changeImgSize("img/settingMenu/Reset_activate.png"));
        ImageIcon reset_disabled = new ImageIcon(changeImgSize("img/settingMenu/Reset_disabled.png"));

        JPanel levelPanel = new JPanel();
        level = new JButton(level_disabled);
        level.setRolloverIcon(level_activate);
        level.setBorderPainted(false);
        level.setPreferredSize(new Dimension(180, 60));
        level.addActionListener(listner);
        level.setOpaque(false);
        levelPanel.add(level);

        JPanel colorWeakPanel = new JPanel();
        colorWeak = new JButton(colorweak_disabled);
        colorWeak.setRolloverIcon(colorweak_activate);
        colorWeak.setBorderPainted(false);
        colorWeak.setPreferredSize(new Dimension(180, 60));
        colorWeak.addActionListener(listner);
        colorWeak.setOpaque(false);
        colorWeakPanel.add(colorWeak);

        JPanel displayPanel = new JPanel();
        display = new JButton(display_disabled);
        display.setRolloverIcon(display_activate);
        display.setBorderPainted(false);
        display.setPreferredSize(new Dimension(180, 60));
        display.addActionListener(listner);
        display.setOpaque(false);
        displayPanel.add(display);

        JPanel keySettingPanel = new JPanel();
        keySetting = new JButton(keymapping_disabled);
        keySetting.setRolloverIcon(keymapping_activate);
        keySetting.setBorderPainted(false);
        keySetting.setPreferredSize(new Dimension(180, 60));
        keySetting.addActionListener(listner);
        keySetting.setOpaque(false);
        keySettingPanel.add(keySetting);

        JPanel resetPanel = new JPanel();
        reset = new JButton(reset_disabled);
        reset.setRolloverIcon(reset_activate);
        reset.setBorderPainted(false);
        reset.setPreferredSize(new Dimension(180, 60));
        reset.addActionListener(listner);
        reset.setOpaque(false);
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