package blanc.thomas.dawin.tetris.Model;

interface Movement {
    void rotate();
    void left(Matrix<Integer> grid);
    void right(Matrix<Integer> grid);
    void down(Matrix<Integer> grid);
}
