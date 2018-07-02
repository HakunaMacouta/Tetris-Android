package blanc.thomas.dawin.tetris.Model;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;

import blanc.thomas.dawin.tetris.GameActivity;
import blanc.thomas.dawin.tetris.R;

public class GameEngine extends OnSwipeTouchListener implements Runnable {
	private Handler handler;
	private int gameSpeed = 500;
	static public int numColumns = 10;
	static public int numRows = 34;
	static public int tetrominoPoint = 50;
	static public int linePoint = 100;
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

	Context ctx;

	public GameEngine(Context ctx, Handler handler,TextView scoreTextView, TextView levelTextView, TextView linesTextView) {
		super(ctx);
		this.ctx = ctx;
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
		updateGrid(Direction.Down);
		System.out.println(current.x() + "  " + current.y());
		this.handler.postDelayed(this, gameSpeed);
	}

	private void clearGrid() {
		for(int i = 0; i < current.matrix().length; i++) {
			for(int j = 0; j < current.matrix()[i].length; j++) {
				if(current.y() + i >= GameEngine.numRows ||
						current.x() + j < 0 ||
						current.x() + j >= GameEngine.numColumns) {
					continue;
				}
				if(!bufferMatrix.get(current.x() + j, current.y() + i)) {
					gameMatrix.set(current.x() + j, current.y() + i, R.drawable.block_empty);
				}
			}
		}
		gameAdapter.notifyDataSetChanged();
	}

	private void updateGrid(Direction dir) {
		boolean canMove = false;
		switch (dir) {
			case Left: canMove = current.left(bufferMatrix); break;
			case Down: canMove = current.down(bufferMatrix); break;
			case Right: canMove = current.right(bufferMatrix); break;
		}

		if(canMove) {
			for(int i = 0; i < current.matrix().length; i++) {
				for(int j = 0; j < current.matrix()[i].length; j++) {
					if(current.matrix()[i][j]) {
						this.gameMatrix.set(current.x() + j, current.y() + i, current.sprite());
					}
				}
			}
			gameAdapter.notifyDataSetChanged();
		} else if(dir == Direction.Down) {
			tetrominoPlaced();
		}
	}

	private void tetrominoPlaced() {
		for(int i = 0; i < current.matrix().length; i++) {
			for (int j = 0; j < current.matrix()[i].length; j++) {
				if(current.matrix()[i][j]) {
					this.gameMatrix.set(current.x() + j, current.y() + i, current.sprite());
					this.bufferMatrix.set(current.x() + j, current.y() + i, true);
				}
			}
		}
		deleteLines();
		score += tetrominoPoint;
		this.current = this.next;
		this.next = TetrominoFactory.createTetromino();
		fillNextGrid();
		updateTextViews();
	}
	private void deleteLines() {
		ArrayList<Integer> lines = new ArrayList<>();
		for(int i = bufferMatrix.height(); i >= 0; i--) {
			boolean line = true;
			for(int j = 0; j < bufferMatrix.width(); j++) {
				if(!bufferMatrix.get(i, j)) {
					line = false;
				}
			}
			if(line) {
				lines.add(i);
			}
		}
		for(int l : lines) {
			for(int i = l; i < bufferMatrix.height(); i++) {
				for(int j = 0; j < bufferMatrix.width(); j++) {
					bufferMatrix.set(i - 1, j, bufferMatrix.get(i, j));
				}
			}
		}
//		System.out.print(bufferMatrix.toString());
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

	public void rotateCurrent() {
		this.current.rotate(bufferMatrix);
	}

	public void onSwipeRight() {
		clearGrid();
		updateGrid(Direction.Right);
	}

	public void onSwipeLeft() {
		clearGrid();
		updateGrid(Direction.Left);
	}
	public void onSwipeBottom() {
		clearGrid();
		updateGrid(Direction.Down);
	}

	public GridAdapter getGameAdapter() {
		return gameAdapter;
	}

	public GridAdapter getNextAdapter() {
		return nextAdapter;
	}
}
