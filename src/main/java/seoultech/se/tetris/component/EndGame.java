package seoultech.se.tetris.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGame extends JFrame {
    private JPanel scorePane, scoreBoardPane, textPane, menuPane;
    private JTextField writeName;
    private JButton restart, terminate, addButton;

    public EndGame(int x, int y, int score) {
        this.setLocation(x,y);
        this.setSize(600,500);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        setScorePane(score);
        setScoreBoardPane();
        setTextPane();
        setMenuPane();


        this.add(scorePane);
        this.add(scoreBoardPane);
        this.add(textPane);
        this.add(menuPane);

        setTitle("게임 종료");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void setScorePane(int score) {
        scorePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel scoreLable = new JLabel(score+"점");
        scoreLable.setFont(scoreLable.getFont().deriveFont(30.f));
        scorePane.add(scoreLable);
    }


    void setScoreBoardPane(){
        scoreBoardPane = new JPanel(new FlowLayout());
        // scoreBoard에 textpane추가
        JPanel scoreBoard = ScoreBoard.tablePane;
        JButton demo = new JButton("여기에 scoreboard들어와야함");
        scoreBoard.setPreferredSize(new Dimension(this.getWidth()-20, this.getHeight()/2));


        scoreBoardPane.add(scoreBoard);
    }

    void setTextPane(){
        textPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        writeName = new JTextField(27);

        addButton = new JButton("등록");

        textPane.add(writeName);
        textPane.add(addButton);
    }

    void setMenuPane() {
        menuPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 0));
        terminate = new JButton("메인화면");
        restart = new JButton("다시하기");

        terminate.setPreferredSize(new Dimension(85, 85));
        restart.setPreferredSize(new Dimension(85, 85));

        terminate.addActionListener(listner);
        restart.addActionListener(listner);

        menuPane.add(restart);
        menuPane.add(terminate);
    }
    ActionListener listner = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(terminate.equals(e.getSource())){ //terminateButton pressed
                disPose();
                new TetrisMenu(getLocation().x, getLocation().y);
                disPose();
            }
            else if(restart.equals(e.getSource())){ // restartButton pressed
                System.out.println("이것 호출");
                new Board(getLocation().x, getLocation().y);
                disPose();
            }
            else { //addButton pressed

            }
        }
    };
    void disPose() {
        this.dispose();
    }

}

