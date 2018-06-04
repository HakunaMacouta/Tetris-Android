package blanc.thomas.dawin.tetris.Model;

import java.util.Random;

public abstract class Tetromino implements Movement {
    protected int height;
    protected int width;
    protected boolean[][] matrix;
    protected int x;
    protected int y;
    protected int sprite;

    Tetromino(int sprite) {
        Random rand = new Random();
        this.x = 0;
        this.y = 0;
        this.sprite = sprite;
    }

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
}
