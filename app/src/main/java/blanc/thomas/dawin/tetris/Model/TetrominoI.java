package blanc.thomas.dawin.tetris.Model;
/**
 *
 */
public class TetrominoI extends Tetromino {
    public TetrominoI(int sprite) {
        super(sprite);
        this.width = 1;
        this.height = 4;
        this.matrix = new boolean[][] {
	        { true },
	        { true },
	        { true },
	        { true }
        };
    }

    @Override
    public void rotate() {

    }
}
