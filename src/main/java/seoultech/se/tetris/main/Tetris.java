package seoultech.se.tetris.main;

import seoultech.se.tetris.component.Board;
import seoultech.se.tetris.component.TetrisMenu;
import seoultech.se.tetris.component.model.Data;

import java.io.IOException;

public class Tetris {

	public static void main(String[] args) throws IOException {

		Data data = new Data();

		TetrisMenu main = new TetrisMenu(600,500);
//		Board main = new Board();
//		main.setSize(500, 600);
//		main.setVisible(true);
	}
}