package seoultech.se.tetris.blocks;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public abstract class Block {

	protected int[][] shape;
	protected Color color;
	protected int centermoved_x;
	protected int centermoved_y;
	protected static boolean color_weak = true;
	protected static boolean item_mode = true;

	public Block() throws IOException {
		shape = new int[][]{ 
				{1, 1}, 
				{1, 1}
		};
		color = Color.YELLOW;
		centermoved_x = 0;
		centermoved_y = 0;
	}

	public int getCentermovedX() {
		return centermoved_x;
	}

	public int getCentermovedY() {
		return centermoved_y;
	}

	public int getShape(int x, int y) {
		return shape[y][x];
	}
	
	public Color getColor() {
		return color;
	}
	
	public void rotate() {
		int[][] rotate;
		rotate = new int[width()][height()];
		for(int i=0; i<rotate.length; i++){
			for(int j=0; j<rotate[i].length; j++)
			{
				rotate[i][j] = shape[height()-1-j][i];
				if(rotate[i][j] == 2 || rotate[i][j] == 12){
					centermoved_y = (height() -1 -j -i);
					centermoved_x = (i - j);
				}
			}
		}
		shape = new int[rotate.length][rotate[0].length];
		for(int i=0; i<rotate.length; i++){
			for(int j=0; j<rotate[0].length; j++)
				shape[i][j] = rotate[i][j];
		}
		//System.out.println(centermoved_x + " " + centermoved_y);
		//Rotate the block 90 deg. clockwise.
	}

	public void canRotate() {
		int[][] rotate;
		rotate = new int[width()][height()];
		for(int i=0; i<rotate.length; i++){
			for(int j=0; j<rotate[i].length; j++)
			{
				rotate[i][j] = shape[height()-1-j][i];
				if(rotate[i][j] == 2 || rotate[i][j] == 12){
					centermoved_y = (height() -1 -j -i);
					centermoved_x = (i - j);
				}
			}
		}
	}
	
	public int height() {
		return shape.length;
	}
	
	public int width() {
		if(shape.length > 0)
			return shape[0].length;
		return 0;
	}

	public void setColorWeak(boolean a){
		color_weak=a;
	}

	public boolean getColorWeak(){
		return color_weak;
	}

	public void setLineCleaner(){
		Random rn = new Random();
		int h=rn.nextInt(height());
		int w=rn.nextInt(width());
		while(shape[h][w]==0){
			h=rn.nextInt(height());
			w=rn.nextInt(width());
		}
		shape[h][w]+=10;
		System.out.println(Arrays.deepToString(shape));
	}
	public void setItemMode(boolean a){ item_mode=a;}

	public boolean getItemMode(){return item_mode;	}
}
