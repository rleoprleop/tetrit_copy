package seoultech.se.tetris.blocks;

import seoultech.se.tetris.component.Board;

import java.awt.*;

public class IBlock extends Block {
	
	public IBlock() {
		shape = new int[][] { 
			{1, 2, 1, 1}
		};


		if(color_weak)
			color= new Color(0x56b5e3);
		else
			color = Color.CYAN;

		if(item_mode && Board.getScore()>1){
			setLineCleaner();
		}
	}
}
