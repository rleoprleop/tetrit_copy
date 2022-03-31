package seoultech.se.tetris.component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreBoard  extends JFrame{
    private JButton backButton;
    private JPanel buttonPane;
    public static JPanel tablePane;
    public static JScrollPane scoreTable;

    public  ScoreBoard(int x, int y){
       this.setLocation(x, y);
       this.setTitle("SeoulTech SE Tetris");
       this.setSize(500, 600);
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       backButton =  new JButton("Back");
       buttonPane = new JPanel();
       buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
       buttonPane.add(backButton);


       String data[][]={ {"User1","12","2"},
               {"User2","20","1"},
               {"User3","10","3"}};
       String column[]={"Player Name","Score","Level"};

       JTable table=new JTable(data,column);
       //table.setBounds(30,40,200,300);
       scoreTable=new JScrollPane(table);

       tablePane = new JPanel();
       tablePane.setLayout(new FlowLayout());
//       tablePane.add(sp,BorderLayout.NORTH);
        tablePane.add(scoreTable);

        this.add(buttonPane, BorderLayout.NORTH);

        this.add(tablePane,BorderLayout.CENTER);

        backButton.addMouseListener(new MyMouseListener());
        this.setVisible(true);
   }

   private void disPose() {
       this.dispose();
   }

   private JFrame getThis(){
        return this;
   }

   class MyMouseListener extends MouseAdapter {
	    public void mouseClicked(MouseEvent evt) {
	    	new TetrisMenu(getThis().getLocation().x,getThis().getLocation().y);
            disPose();
	    }
	}
}
