package blanc.thomas.dawin.tetris.Model;

public class TetrominoL extends Tetromino {
    TetrominoL(int sprite) {
        super(sprite);
        this.width = 3;
        this.height = 2;
        this.matrix = new boolean[][]
        {
	        { true, false },
	        { true, false },
	        { true, true }
        };
    }

    @Override
    public void rotate() {

    }
}
