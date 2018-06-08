package blanc.thomas.dawin.tetris.Model;

public class TetrominoT extends Tetromino {
    TetrominoT(int sprite) {
        super(sprite);
        this.width = 3;
        this.height = 2;
        this.matrix = new boolean[][]
            {
                { false, true, false },
                { true, true, true }
            };
    }

    @Override
    public void rotate() {

    }
}
