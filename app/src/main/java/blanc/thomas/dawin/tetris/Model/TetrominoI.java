package blanc.thomas.dawin.tetris.Model;
/**
 *
 */
public class TetrominoI extends Tetromino {
    public TetrominoI(int sprite) {
        super(sprite);
        this.width = 1;
        this.height = 4;
        this.matrix = new boolean[width][height];
        for (int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.height; j++) {
                this.matrix[i][j] = true;
            }
        }
    }

    @Override
    public void rotate() {

    }
}
