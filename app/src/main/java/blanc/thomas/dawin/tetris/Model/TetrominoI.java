package blanc.thomas.dawin.tetris.Model;
/**
 *
 */
public class TetrominoI extends Tetromino {
	public TetrominoI(int sprite) {
		super(sprite);
		this.matrix = new boolean[][] {
				{ false, true, false, false },
				{ false, true, false, false },
				{ false, true, false, false },
				{ false, true, false, false }
		};
	}
}
