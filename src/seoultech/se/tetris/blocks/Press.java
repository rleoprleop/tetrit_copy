package seoultech.se.tetris.blocks;

import seoultech.se.tetris.component.Board;

import java.awt.*;
import java.io.IOException;

public class Press extends Block {

    public Press() throws IOException {
        shape = new int[][] {
                {6, 6, 6, 6},
                {6, 6, 6, 6}
        };
        color=Color.white;
    }
}
