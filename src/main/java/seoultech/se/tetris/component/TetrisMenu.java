package seoultech.se.tetris.component;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class TetrisMenu extends JFrame {
    private String menuList[] = {"게임 시작","스코어 보드","설정","게임종료"};
    private Container c;
    private int menuNum = 0;
    //private JPanel mainPanel;
    private JPanel gameNamePane;
    private JPanel menuPane;
    private JButton menuButton;
    private KeyListener keylistner;
    private int frameWidth = 500;
    private int frameHeight = 600;
    private JLabel upLabel,downLabel;


    public TetrisMenu(int x, int y) {
        this.setSize(frameWidth, frameHeight);
        this.setLocation(x, y);
        this.setLayout(new GridLayout(2,1,10,0));
        //mainPanel = new JPanel();
        displayGameName();
        setButton();
        keylistner = new MenuKeyListener();
        this.addKeyListener(keylistner);
        this.setFocusable(true);
        menuButton.addKeyListener(keylistner);
        menuButton.setFocusable(true);


        this.add(gameNamePane);
        this.add(menuPane);

        setTitle("StartScreen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void displayGameName(){
        gameNamePane = new JPanel();
        JLabel gameLable = new JLabel("SeoulTech SE Tetris");
        gameLable.setFont(gameLable.getFont().deriveFont(40.0f));
//        gameLable.setHorizontalAlignment(JLabel.CENTER);
//        gameLable.setVerticalAlignment(JLabel.CENTER);
        gameNamePane.add(gameLable);
    }

    private Image changeImgSize(String path){
        ImageIcon img = new ImageIcon(path);
        Image img1 = img.getImage();
        Image changeImg = img1.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        return changeImg;
    }

    void setButton() {
        ImageIcon upImg = new ImageIcon(changeImgSize("img/up.png"));
        ImageIcon downImg = new ImageIcon(changeImgSize("img/down.png"));
        upLabel = new JLabel(upImg);
        downLabel = new JLabel(downImg);

        menuPane = new JPanel(new GridLayout(3,1,5,0));

        menuButton = new JButton((menuList[menuNum]));
        menuButton.setFont(menuButton.getFont().deriveFont(30.0f));
        menuPane.add(upLabel);
        menuPane.add(menuButton);
        menuPane.add(downLabel);
    }

    void enterPressed() throws IOException {
        switch (menuNum){

            case 0: //board class
                Board gameStart = new Board(this.getLocation().x, this.getLocation().y);
                this.dispose();
                break;
            case 1: //score board class
                ScoreBoard scoreboard = new ScoreBoard(this.getLocation().x, this.getLocation().y);
                this.dispose();
                break;
            case 2: //setting class
                new Setting(this.getLocation().x, this.getLocation().y);
                this.dispose();
                break;
            case 3://exit game
                System.exit(0);
                break;
            default:
        }
    }

    private class MenuKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            int button_size = menuList.length;

            switch(e.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    //해당 class로 이동
                    try {
                        enterPressed();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    menuNum = (menuNum + 1)%button_size;
                    menuButton.setText(menuList[menuNum]);
                    break;

                case KeyEvent.VK_UP:
                    if(menuNum == 0) menuNum = button_size-1;
                    else   menuNum--;
                    menuButton.setText(menuList[menuNum]);

                    break;

                default:
                    System.out.println("error");
                    JOptionPane errorPane = new JOptionPane();
                    errorPane.showMessageDialog(null, "up, down, enter만 누를수 있습니다.","KEY_ERROR", JOptionPane.WARNING_MESSAGE);


                    /*
                    경고창 class 호출

                    content : u can press up down enter

                    -> button(확인)
                     */

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
