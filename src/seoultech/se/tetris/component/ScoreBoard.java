package seoultech.se.tetris.component;



import javax.swing.*;

public class ScoreBoard {

    JFrame f;
    private int frameWidth = 500;
    private int frameHeight = 600;
    ScoreBoard(){
        f=new JFrame();

        String data[][]={ {"User1","12","2"},
                {"User2","20","1"},
                {"User3","10","3"}};
        String column[]={"Player Name","Score","Level"};

        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,200,300);

        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);

        f.setSize(300,400);
        //  f.setLayout(null);
        f.setTitle("SCORE");
        f.setSize(frameWidth, frameHeight);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new ScoreBoard();
    }
}


