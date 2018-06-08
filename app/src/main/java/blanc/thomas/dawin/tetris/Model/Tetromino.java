package blanc.thomas.dawin.tetris.Model;

public abstract class Tetromino implements Movement {
    protected boolean[][] matrix;
    private int x;
    private int y;
	private int sprite;

    Tetromino(int sprite) {
        this.x = 0;
        this.y = GameEngine.numColumns/2;
        this.sprite = sprite;
    }

    public int x() { return x; }
    public int y() { return y; };
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void left(Matrix<Integer> grid) {
        if (canMove(grid, Direction.Left)) {
	        this.x -= 1;
        }
    }

    @Override
    public void right(Matrix<Integer> grid) {
    	if(canMove(grid, Direction.Right))
        this.x += 1;
    }

    @Override
    public void down(Matrix<Integer> grid) {
    	if(canMove(grid, Direction.Down))
        this.y += 1;
    }

    public int sprite() {
        return sprite;
    }

    public boolean[][] matrix() {
        return this.matrix;
    }

    private boolean canMove(Matrix<Integer> gameGrid, Direction dir) {
    	switch (dir) {
		    case Left:
			    break;
		    case Down:
			    break;
		    case Right:
			    break;
	    }
    	return true;
    }
}
