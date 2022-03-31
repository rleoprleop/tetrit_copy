package seoultech.se.tetris.component.setting;

import javax.swing.*;
import java.awt.*;

public class LevelSetting extends JFrame {
    private Container container;
    private JPanel backButtonPanel, menuPanel;
    private JButton backButton;
    private JButton easy, normal, hard;

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

        JPanel easyPanel = new JPanel();
        easy = new JButton("Level");
        easy.setPreferredSize(new Dimension(180, 60));
        easyPanel.add(easy);

        JPanel normalPanel = new JPanel();
        normal = new JButton("Color_Weak");
        normal.setPreferredSize(new Dimension(180, 60));
        normalPanel.add(normal);

        JPanel hardPanel  = new JPanel();
        hard = new JButton("Display");
        hard.setPreferredSize(new Dimension(180, 60));
        hardPanel.add(hard);



        menuPanel.add(easyPanel);
        menuPanel.add(normalPanel);
        menuPanel.add(hardPanel);
    }


}
