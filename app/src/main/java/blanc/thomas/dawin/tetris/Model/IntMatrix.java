package blanc.thomas.dawin.tetris.Model;

import blanc.thomas.dawin.tetris.R;

public class IntMatrix {
    private int rows;
    private int cols;
    private int[] data;

    public IntMatrix(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.data = new int[cols * rows];
        for(int i = 0; i < data.length; i++) {
            data[i] = R.drawable.block_empty;
        }
    }

    private static int getIndex(int col, int row, int width) {
        return  row * width + col;
    }

    public int get(int col, int row) {
        return data[getIndex(col, row, cols)];
    }

    public void set(int col, int row, int value) {
        data[getIndex(col, row, cols)] = value;
    }

    public int[] data() {
        return data;
    }
}
