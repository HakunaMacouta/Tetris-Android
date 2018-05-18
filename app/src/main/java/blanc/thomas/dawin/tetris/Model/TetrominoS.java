package blanc.thomas.dawin.tetris.Model;

public class TetrominoS extends Tetromino {
    TetrominoS(int sprite) {
        super(sprite);
        this.width = 3;
        this.height = 2;
        this.matrix = new boolean[][]
            {
                { false, true, true },
                { true, true, false }
            };
    }

    @Override
    public void rotate() {

    }
}
