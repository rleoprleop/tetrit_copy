package seoultech.se.tetris.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pause extends JFrame {
    private static final int BACK = 1;
    private static final int END = 2;
    private static int[] menu = {BACK, END};
    private static int status = 1;
    private static int numMenu = menu.length;
    private JPanel scorePane;
    private JPanel menuPane;
    private Board board1;
    public Pause(int x, int y, int frameW, int frameH, Board board){
        board1 = board;
        this.setSize(frameW, frameH/2);
        this.setLocation(x, frameH/2 - frameH/4+y);
        this.setLayout(new GridLayout(3,1,10,0));

        status = 1;
        numMenu = menu.length;
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
        menuPane = new JPanel(new FlowLayout());

        JButton backGame = new JButton("돌아가기");
        JButton terminate = new JButton("게임 종료");
        backGame.setPreferredSize(new Dimension(160,100));
        terminate.setPreferredSize(new Dimension(160,100));

        backGame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        if (status == BACK) {
                            board1.pause();
                            dispose();
                        } else if (status == END) {
                            dispose();
                            board1.dispose();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(status < numMenu) {
                            status++;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if(status > 1)
                            status--;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        menuPane.add(backGame);
        menuPane.add(terminate);

    }
}
