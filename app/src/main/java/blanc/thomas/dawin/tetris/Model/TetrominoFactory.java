package blanc.thomas.dawin.tetris.Model;

import blanc.thomas.dawin.tetris.R;

public class TetrominoFactory {
    static public Tetromino createTetromino() {
        Tetromino tetromino = null;
        switch (TetrominoType.randomTetrominoType()) {
            case I: tetromino = new TetrominoI(R.drawable.block_i); break;
            case J: tetromino = new TetrominoJ(R.drawable.block_j); break;
            case L: tetromino = new TetrominoL(R.drawable.block_l); break;
            case O: tetromino = new TetrominoO(R.drawable.block_o); break;
            case S: tetromino = new TetrominoS(R.drawable.block_s); break;
            case T: tetromino = new TetrominoT(R.drawable.block_t); break;
        }
        return tetromino;
    }
}
