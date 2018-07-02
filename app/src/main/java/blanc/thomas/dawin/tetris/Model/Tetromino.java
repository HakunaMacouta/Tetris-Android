package blanc.thomas.dawin.tetris.Model;

public abstract class Tetromino implements Movement {
	protected boolean[][] matrix;
	private int x, y;
	private int sprite;
	private int width, height;

	Tetromino(int sprite) {
		this.x = GameEngine.numColumns/2 - 2;
		this.y = 0;
		this.sprite = sprite;
	}

	public int x() { return x; }
	public int y() { return y; };

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void rotate(Matrix<Boolean> grid) {
		int size = matrix.length;
		boolean[][] oldMatrix = matrix;
		for (int x = 0; x < size / 2; x++)
		{
			for (int y = x; y < size-x-1; y++)
			{
				boolean temp = matrix[x][y];
				matrix[x][y] = matrix[y][size-1-x];
				matrix[y][size-1-x] = matrix[size-1-x][size-1-y];
				matrix[size-1-x][size-1-y] = matrix[size-1-y][x];
				matrix[size-1-y][x] = temp;
			}
		}
		if(!canMove(grid, Direction.Down) || !canMove(grid, Direction.Left) || !canMove(grid, Direction.Right)) {
			matrix = oldMatrix;
		}
	}
	@Override
	public boolean left(Matrix<Boolean> grid) {
		boolean canMove = canMove(grid, Direction.Left);
		if (canMove) {
			this.x -= 1;
		}
		return canMove;
	}

	@Override
	public boolean right(Matrix<Boolean> grid) {
		boolean canMove = canMove(grid, Direction.Right);
		if(canMove) {
			this.x += 1;
		}
		return canMove;
	}

	@Override
	public boolean down(Matrix<Boolean> grid) {
		boolean canMove = canMove(grid, Direction.Down);
		if(canMove) {
			this.y += 1;
		}
		return canMove;
	}

	public int sprite() {
		return sprite;
	}

	public boolean[][] matrix() {
		return this.matrix;
	}

	private boolean canMove(Matrix<Boolean> gameGrid, Direction dir) {
		switch (dir) {
			case Left:
				for(int i = 0; i < this.matrix.length; i++) {
					for (int j = 0; j < this.matrix[i].length; j++) {
						if(this.matrix[i][j] && (this.x + j - 1 < 0 || gameGrid.get(this.x + j - 1, this. y + i))) {
							return false;
						}
					}
				}
				break;
			case Down:
				for(int i = 0; i < this.matrix.length; i++) {
					for(int j = 0; j < this.matrix[i].length; j++) {
						if(this.matrix[i][j] && (this.y + i + 1 >= GameEngine.numRows)) {
							return false;
						} else if(this.matrix[i][j] && gameGrid.get(this.x + j, this.y + i + 1)) {
							return false;
						}
					}
				}
				break;
			case Right:
				for(int i = 0; i < this.matrix.length; i++) {
					for (int j = 0; j < this.matrix[i].length; j++) {
						if(this.matrix[i][j] && (this.x + j + 1 >= GameEngine.numColumns || gameGrid.get(this.x + j + 1, this.y + i))) {
							return false;
						}
					}
				}
				break;
		}
		return true;
	}
}
