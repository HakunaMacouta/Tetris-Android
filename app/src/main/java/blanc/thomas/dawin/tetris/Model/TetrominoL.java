package blanc.thomas.dawin.tetris.Model;

public class TetrominoL extends Tetromino {
	TetrominoL(int sprite) {
		super(sprite);
		this.matrix = new boolean[][] {
				{ false, true, false, false },
				{ false, true, false, false },
				{ false, true, true, false },
				{ false, false, false, false }
		};
	}

	@Override
	public void rotate() {

	}
}
