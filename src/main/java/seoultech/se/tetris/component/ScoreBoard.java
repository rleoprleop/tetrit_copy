package seoultech.se.tetris.component;
import seoultech.se.tetris.component.model.ScoreDataManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreBoard  extends JFrame{
    private JButton backButton;
    private JPanel backButtonPane;
    public static JPanel tablePane;
    public static final String column[]={"순위","Player Name","Score"};


    public  ScoreBoard(int x, int y){
       this.setLocation(x, y);
       this.setTitle("SeoulTech SE Tetris");
       this.setSize(500, 600);
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setBackButtonPane();
        setScoreTablePane();

       this.add(backButtonPane, BorderLayout.NORTH);
       this.add(tablePane,BorderLayout.CENTER);

       this.setVisible(true);
   }

   private void setBackButtonPane() {
       backButton =  new JButton("Back");
       backButton.addMouseListener(new MyMouseListener());

       backButtonPane = new JPanel();
       backButtonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
       backButtonPane.add(backButton);
   }

   private void setScoreTablePane () {
       JScrollPane scrollPane = new JScrollPane(getScoreTable());

       tablePane = new JPanel();
       tablePane.setLayout(new FlowLayout());
       tablePane.add(scrollPane);
   }

   public static JTable getScoreTable(){
       String data[][]= ScoreDataManager.getInstance().getStringData();
       JTable scoreTable=new JTable(data,column);
       return scoreTable;
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
