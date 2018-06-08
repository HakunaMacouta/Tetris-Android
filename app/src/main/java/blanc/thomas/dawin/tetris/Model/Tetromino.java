package blanc.thomas.dawin.tetris.Model;

import java.util.Random;

public abstract class Tetromino implements Movement {
    protected int height;
    protected int width;
    protected boolean[][] matrix;
    private int x;
    private int y;
	private int sprite;

    Tetromino(int sprite) {
        this.x = 5;
        this.y = 5;
        this.sprite = sprite;
    }

    public int x() { return x; }
    public int y() { return y; };
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void left() {
        this.x -= 1;
    }

    @Override
    public void right() {
        this.x += 1;
    }

    @Override
    public void down() {
        this.y += 1;
    }

    public int sprite() {
        return sprite;
    }

    public boolean[][] matrix() {
        return this.matrix;
    }
}
