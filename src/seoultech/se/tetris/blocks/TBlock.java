package seoultech.se.tetris.blocks;

import java.awt.Color;

public class TBlock extends Block {
	
	public TBlock() {
		shape = new int[][] { 
			{0, 1, 0},
			{1, 2, 1}
		};
		if(color_weak)
			color= new Color(0xd5933e);
		else
			color = Color.MAGENTA;
	}
}
