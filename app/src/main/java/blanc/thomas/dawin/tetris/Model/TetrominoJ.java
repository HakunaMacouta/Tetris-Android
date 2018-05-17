package blanc.thomas.dawin.tetris.Model;

import java.util.Arrays;

public class TetrominoJ extends Tetromino implements Movement {
    TetrominoJ(int sprite) {
        super(sprite);
        this.width = 3;
        this.height = 2;
        this.matrix = new boolean[width][height];
        this.matrix[0][0] = true;
        for(int i = 0; i < width; i++) {
            this.matrix[i][1] = true;
        }
    }

    @Override
    public void rotate() {

    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void down() {

    }
}
