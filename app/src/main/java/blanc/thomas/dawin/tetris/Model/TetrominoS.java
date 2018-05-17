package blanc.thomas.dawin.tetris.Model;

public class TetrominoS extends Tetromino implements Movement {
    TetrominoS(int sprite) {
        super(sprite);
        this.width = 3;
        this.height = 2;
        this.matrix = new boolean[width][height];
        this.matrix[0][0] = true;
        this.matrix[1][0] = true;
        this.matrix[1][1] = true;
        this.matrix[2][1] = true;
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
