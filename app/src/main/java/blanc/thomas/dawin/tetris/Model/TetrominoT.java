package blanc.thomas.dawin.tetris.Model;

public class TetrominoT extends Tetromino {
    TetrominoT(int sprite) {
        super(sprite);
        this.matrix = new boolean[][] {
                { false, false, false, false },
                { false, true, false, false },
                { true, true, true, false },
                { false, false, false, false }
        };
    }

    @Override
    public void rotate() {

    }
}
