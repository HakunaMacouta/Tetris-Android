package blanc.thomas.dawin.tetris.Model;

interface Movement {
    void rotate(Matrix<Boolean> grid);
    boolean left(Matrix<Boolean> grid);
    boolean right(Matrix<Boolean> grid);
    boolean down(Matrix<Boolean> grid);
}
