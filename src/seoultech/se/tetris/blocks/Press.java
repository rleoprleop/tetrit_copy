package seoultech.se.tetris.blocks;

import seoultech.se.tetris.component.Board;

import java.awt.*;

public class Press extends Block {

    public Press() {
        shape = new int[][] {
                {6, 6, 6, 6},
                {6, 6, 6, 6}
        };
        color=Color.white;
    }
}
