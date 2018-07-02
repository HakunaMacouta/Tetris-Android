package blanc.thomas.dawin.tetris.Model;

import java.util.Arrays;

class TetrominoO extends Tetromino {
    TetrominoO(int sprite) {
        super(sprite);
        this.matrix = new boolean[][] {
                { false, false, false, false },
                { false, true, true, false },
                { false, true, true, false },
                { false, false, false, false }
        };
    }
}
