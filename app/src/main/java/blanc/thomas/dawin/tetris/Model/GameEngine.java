package blanc.thomas.dawin.tetris.Model;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import blanc.thomas.dawin.tetris.GameActivity;
import blanc.thomas.dawin.tetris.R;

public class GameEngine extends OnSwipeTouchListener implements Runnable {
	private Handler handler;
	private int gameSpeed = 500;
	static public int numColumns = 10;
	static public int numRows = 34;
	private Tetromino current, next;

	private Matrix<Integer> gameMatrix, nextMatrix;
	private Matrix<Boolean> bufferMatrix;
	private GridAdapter gameAdapter, nextAdapter;

	private TextView scoreTextView;
	private int score = 0;
	private TextView levelTextView;
	private int level = 1;
	private TextView linesTextView;
	private int lines = 0;

	public GameEngine(Context ctx, Handler handler,TextView scoreTextView, TextView levelTextView, TextView linesTextView) {
		super(ctx);
		this.handler = handler;
		bufferMatrix = new Matrix<>(Boolean.class, numColumns, numRows, false);
		gameMatrix = new Matrix<>(Integer.class, numColumns, numRows, R.drawable.block_empty);
		nextMatrix = new Matrix<>(Integer.class, 4,4, R.drawable.block_empty);
		gameAdapter = new GridAdapter(ctx, gameMatrix.data());
		nextAdapter = new GridAdapter(ctx, nextMatrix.data());
		current = TetrominoFactory.createTetromino();
		next = TetrominoFactory.createTetromino();
		fillNextGrid();
		this.scoreTextView = scoreTextView;
		this.levelTextView = levelTextView;
		this.linesTextView = linesTextView;
		updateTextViews();
	}

	@Override
	public void run() {
		clearGrid();
		updateGrid();
		this.handler.postDelayed(this, gameSpeed);
	}

	private void clearGrid() {
		for(int i = 0; i < current.matrix().length; i++) {
			for(int j = 0; j < current.matrix()[i].length; j++) {
				if(!bufferMatrix.get(current.x() + j, current.y() + i)) {
					gameMatrix.set(current.x() + j, current.y() + i, R.drawable.block_empty);
				}
			}
		}
		gameAdapter.notifyDataSetChanged();
	}

	private void updateGrid() {
		current.down(gameMatrix);
		for(int i = 0; i < current.matrix().length; i++) {
			for(int j = 0; j < current.matrix()[i].length; j++) {
				if(current.matrix()[i][j]) {
					this.gameMatrix.set(current.x() + j, current.y() + i, current.sprite());
				}
			}
		}
		gameAdapter.notifyDataSetChanged();
	}

	private void updateTextViews() {
		scoreTextView.setText("" + score);
		levelTextView.setText("" + level);
		linesTextView.setText("" + lines);
	}

	private void fillNextGrid() {
		for(int i = 0; i < nextMatrix.width(); i++) {
			for(int j = 0; j < nextMatrix.height(); j++) {
				if(next.matrix()[i][j]) {
					nextMatrix.set(i, j, next.sprite());
				} else {
					nextMatrix.set(i, j, R.drawable.block_empty);
				}
			}
		}
		nextAdapter.notifyDataSetChanged();
	}

	public void onSwipeRight() {
		clearGrid();
		current.right(gameMatrix);
		updateGrid();
	}

	public void onSwipeLeft() {
		clearGrid();
		current.left(gameMatrix);
		updateGrid();
	}
	public void onSwipeBottom() {
		clearGrid();
		updateGrid();
	}
	public GridAdapter getGameAdapter() {
		return gameAdapter;
	}

	public GridAdapter getNextAdapter() {
		return nextAdapter;
	}
}
