package seoultech.se.tetris.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pause extends JFrame {

    private JPanel scorePane;
    private JPanel menuPane;
    private Board board1;
    public Pause(int x, int y, int frameW, int frameH, Board board){
        board1 = board;
        this.setSize(frameW, frameH/2);
        this.setLocation(x, frameH/2 - frameH/4+y);
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
        menuPane = new JPanel(new GridLayout(1, 2, 0, 5));

        JButton backGame = new JButton("돌아가기");
        JButton terminate = new JButton("게임 종료");

        backGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board1.pause();
                dispose();
            }
        });

        terminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TetrisMenu(board1.getLocation().x, board1.getLocation().y);
                dispose();
                board1.dispose();
            }
        });
        menuPane.add(backGame);
        menuPane.add(terminate);

    }
}
