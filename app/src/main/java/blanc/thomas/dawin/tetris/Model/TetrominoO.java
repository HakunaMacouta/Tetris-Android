package blanc.thomas.dawin.tetris.Model;

import java.util.Arrays;

class TetrominoO extends Tetromino {
    TetrominoO(int sprite) {
        super(sprite);
        this.width = 2;
        this.height = 2;
        this.matrix = new boolean[width][height];
        for(boolean[] row : this.matrix) {
            Arrays.fill(row, true);
        }
    }

    @Override
    public void rotate() {

    }
}
