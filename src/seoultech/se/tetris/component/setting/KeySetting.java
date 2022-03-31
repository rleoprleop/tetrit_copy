package seoultech.se.tetris.component.setting;

import seoultech.se.tetris.component.Setting;
import seoultech.se.tetris.component.TetrisMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeySetting extends JFrame {
    private Container container;
    private JPanel backButtonPanel, menuPanel;
    private JButton backButton;
    private JButton down, up, rotate, hardDrop, pause;

    public KeySetting(int x, int y) {
        this.setSize(500, 600);
        this.setLocation(x, y);
        this.setLayout(new BorderLayout(25, 25));

        setbackButtonPanel();
        setMenuPanel();

        this.add(backButtonPanel, BorderLayout.NORTH);
        this.add(new JPanel(), BorderLayout.WEST);
        this.add(menuPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    private void setbackButtonPanel(){
        backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("back");
        backButton.addActionListener(listner);
        backButtonPanel.add(backButton);
    }

    private void setMenuPanel(){
        menuPanel = new JPanel(new GridLayout(5,1,5,0));

        JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        up = new JButton("up");
        up.setPreferredSize(new Dimension(180, 60));
        up.addActionListener(listner);
        upPanel.add(up);

        JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        down = new JButton("down");
        down.setPreferredSize(new Dimension(180, 60));
        down.addActionListener(listner);
        downPanel.add(down);

        JPanel rotatePanel  = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rotate = new JButton("rotate");
        rotate.setPreferredSize(new Dimension(180, 60));
        rotate.addActionListener(listner);
        rotatePanel.add(rotate);

        JPanel hardDropPanel  = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hardDrop = new JButton("hardDrop");
        hardDrop.setPreferredSize(new Dimension(180, 60));
        hardDrop.addActionListener(listner);
        hardDropPanel.add(hardDrop);

        JPanel pausePanel  = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pause = new JButton("pause");
        pause.setPreferredSize(new Dimension(180, 60));
        pause.addActionListener(listner);
        pausePanel.add(pause);

        menuPanel.add(upPanel);
        menuPanel.add(downPanel);
        menuPanel.add(rotatePanel);
        menuPanel.add(hardDropPanel);
        menuPanel.add(pausePanel);
    }
    ActionListener listner = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (backButton.equals(e.getSource())) { //terminateButton pressed
                new Setting(getThis().getLocation().x, getThis().getLocation().y);
                getThis().dispose();
            }
            else if (up.equals(e.getSource())) { // restartButton pressed

            }
            else if (down.equals(e.getSource())) { // restartButton pressed

            }
            else if (rotate.equals(e.getSource())) { // restartButton pressed

            }
            else if (hardDrop.equals(e.getSource())) { // restartButton pressed

            }
            else { // restartButton pressed

            }
        }
    };

    private JFrame getThis() {return this;}

}
