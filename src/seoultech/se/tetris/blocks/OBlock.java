package seoultech.se.tetris.blocks;

import seoultech.se.tetris.component.Board;

import java.awt.Color;

public class OBlock extends Block {

	public OBlock() {
		shape = new int[][] { 
			{1, 1}, 
			{1, 1}
		};
		if(color_weak)
			color= new Color(0xf2e245);
		else
			color = Color.YELLOW;
		if(item_mode && Board.getScore()>1){
			setLineCleaner();
		}
	}
}
