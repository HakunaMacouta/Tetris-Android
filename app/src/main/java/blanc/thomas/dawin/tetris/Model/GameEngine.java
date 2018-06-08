package blanc.thomas.dawin.tetris.Model;

import android.content.Context;
import android.os.Handler;
import blanc.thomas.dawin.tetris.R;

public class GameEngine extends OnSwipeTouchListener implements Runnable {
	private Handler handler;
	private int gameSpeed = 1000;
	private int numColumns = 10;
	private int numRows = 34;
	private Tetromino current, next;

	private Matrix<Integer> gameMatrix;
	private Matrix<Boolean> bufferMatrix;
	private GridAdapter gameAdapter;

	public GameEngine(Context ctx, Handler handler) {
		super(ctx);
		this.handler = handler;
		bufferMatrix = new Matrix<>(Boolean.class, numColumns, numRows, false);
		gameMatrix = new Matrix<>(Integer.class, numColumns, numRows, R.drawable.block_empty);
		gameAdapter = new GridAdapter(ctx, gameMatrix.data());
		current = TetrominoFactory.createTetromino();
		next = TetrominoFactory.createTetromino();

	}

	@Override
	public void run() {
		clearGrid();
		updateGrid();
		this.handler.postDelayed(this, gameSpeed);
	}

	private void clearGrid() {
		for(int i = 0; i < gameMatrix.width(); i++) {
			for(int j = 0; j < gameMatrix.height(); j++) {
				if(!bufferMatrix.get(i, j)) {
					gameMatrix.set(i, j, R.drawable.block_empty);
				}
			}
		}
		gameAdapter.notifyDataSetChanged();
	}

	private void updateGrid() {
		current.down();
		for(int i = 0; i < current.matrix().length; i++) {
			for(int j = 0; j < current.matrix()[i].length; j++) {
				if(current.matrix()[i][j]) {
					this.gameMatrix.set(current.x() + j, current.y() + i, current.sprite());
				}
			}
		}
		gameAdapter.notifyDataSetChanged();
	}

	public GridAdapter adapter() {
		return gameAdapter;
	}

	public void onSwipeRight() {
		clearGrid();
		current.right();
		updateGrid();
	}
	public void onSwipeLeft() {
		clearGrid();
		current.left();
		updateGrid();
	}
	public void onSwipeBottom() {
		clearGrid();
		updateGrid();
	}
}
