package seoultech.se.tetris.blocks;

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
	}
}
