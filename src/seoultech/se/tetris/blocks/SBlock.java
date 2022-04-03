package seoultech.se.tetris.blocks;

import seoultech.se.tetris.component.Board;

import java.awt.Color;

public class SBlock extends Block {

	public SBlock() {
		shape = new int[][] { 
			{0, 1, 1},
			{1, 1, 0}
		};
		if(color_weak)
			color= new Color(0x009f73);
		else
			color = Color.GREEN;
		if(item_mode && Board.getScore()>1){
			setLineCleaner();
		}
	}
}
