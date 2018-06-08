package blanc.thomas.dawin.tetris.Model;

public class TetrominoZ extends Tetromino {
	TetrominoZ(int sprite) {
		super(sprite);
		this.matrix = new boolean[][] {
				{ false, false, false, false },
				{ false, true, true, false },
				{ true, true, false, false },
				{ false, false, false, false },

		};
	}

	@Override
	public void rotate() {

	}
}
