package seoultech.se.tetris.component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ScoreBoard  extends JFrame{
   public ScoreBoard(){
       this.setTitle("SeoulTech SE Tetris");
       this.setSize(500, 600);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



       JButton jButtonBack =  new JButton("Back");
       JPanel jPanel_head = new JPanel();
       jPanel_head.setLayout(new BorderLayout());
       jPanel_head.add(jButtonBack,BorderLayout.WEST);


       String data[][]={ {"User1","12","2"},
               {"User2","20","1"},
               {"User3","10","3"}};
       String column[]={"Player Name","Score","Level"};

       JTable jt=new JTable(data,column);
       jt.setBounds(30,40,200,300);
       JScrollPane sp=new JScrollPane(jt);

       JPanel jPanel_data = new JPanel();
       jPanel_data.setLayout(new BorderLayout());
       jPanel_data.add(sp,BorderLayout.NORTH);

        this.add(jButtonBack, BorderLayout.NORTH);
        this.add(jPanel_data,BorderLayout.CENTER);
        
        jButtonBack.addMouseListener(new MyMouseListener());
        this.setVisible(true);


   }
   class MyMouseListener extends MouseAdapter {
	    public void mouseClicked(MouseEvent evt) {
	    	TetrisMenu startTetrisMenu=new TetrisMenu();
	    	startTetrisMenu.setVisible(true);
	    	startTetrisMenu.setSize(500, 600);
	    	startTetrisMenu.setLocationRelativeTo(null);
	    }
	}
    public static void main(String[] args) {
       ScoreBoard main = new ScoreBoard();
    }


    }
