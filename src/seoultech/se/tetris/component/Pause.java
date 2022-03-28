package seoultech.se.tetris.component;

import javax.swing.*;
import java.awt.*;

public class Pause extends JFrame {
    private int frameWidth = 500;
    private int frameHeight = 600;
    private JPanel scorePane;
    private JPanel menuPane;

    public Pause(){
        this.setSize(frameWidth, frameHeight);

        this.setLayout(new GridLayout(3,1,10,0));
        addScorePannel();
        addMenuPannel();

        this.add(scorePane);
        this.add(menuPane);
        setTitle("PauseScreen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void addScorePannel(){
        JLabel lb = new JLabel("asd");
        scorePane = new JPanel();
    }

    void addMenuPannel(){
        menuPane = new JPanel(new GridLayout(1, 4, 0, 5));

        JButton backGame = new JButton("돌아가기");
        JButton scoreBoard = new JButton("스코어보드");
        JButton startMenu = new JButton("시작화면");
        JButton terminate = new JButton("게임 종료");
        menuPane.add(backGame);
        menuPane.add(scoreBoard);
        menuPane.add(startMenu);
        menuPane.add(terminate);

    }
}
