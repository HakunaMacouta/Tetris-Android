package blanc.thomas.dawin.tetris.Model;

public abstract class Tetromino {
    protected int height;
    protected int width;
    protected boolean[][] matrix;
    protected int x;
    protected int y;
    protected int sprite;

    Tetromino(int sprite) {
        this.x = 0;
        this.y = 0;
        this.sprite = sprite;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
