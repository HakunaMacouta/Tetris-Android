package blanc.thomas.dawin.tetris.Model;

import java.util.Arrays;

public class TetrominoJ extends Tetromino {
    TetrominoJ(int sprite) {
        super(sprite);
        this.matrix = new boolean[][] {
                { false, false, true, false},
                { false, false, true, false},
                { false, true, true, false},
                { false, false, false, false}
        };
    }
}
