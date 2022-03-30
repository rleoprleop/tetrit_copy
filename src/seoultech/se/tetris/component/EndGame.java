package seoultech.se.tetris.component;

import javax.swing.*;
import java.awt.*;

public class EndGame extends JFrame {
    private JPanel scorePane;
    private JPanel scoreBoardPane;
    private JPanel textPane;


    public EndGame(int x, int y, int score) {
        this.setLocation(x,y);
        this.setSize(600,500);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 15,0));
        setScorePane(score);
        this.add(scorePane);
        setTitle("게임 종료");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void setScorePane(int score) {
        scorePane = new JPanel();
        JLabel scoreLable = new JLabel(score+"점");
        scoreLable.setVerticalAlignment(JLabel.CENTER);
        scoreLable.setHorizontalAlignment(JLabel.CENTER);
        scorePane.add(scoreLable);
    }

    void setScoreBoardPane(){
        // boardclass가져옴
    }

}
