package blanc.thomas.dawin.tetris.Model;

import java.lang.reflect.Array;


public class Matrix<E> {
    private int rows;
    private int cols;
    private E[] data;

    public Matrix(Class<E> c, int cols, int rows, E def) {
        this.cols = cols;
        this.rows = rows;
        this.data = (E[]) Array.newInstance(c, this.cols * this.rows);
        for(int i = 0; i < data.length; i++) {
            data[i] = def;
        }
    }

    private static int getIndex(int col, int row, int width) {
        return  row * width + col;
    }

    public E get(int col, int row) {
        return data[getIndex(col, row, cols)];
    }

    public void set(int col, int row, E value) {
        data[getIndex(col, row, cols)] = value;
    }

    public E[] data() {
        return data;
    }

    public int width() { return this.cols; }

    public int height() { return this.rows; }

    public String toString() {
        String txt = "";
    	for(int i = 0; i < this.rows; i++) {
    		for(int j = 0; j < this.cols; j++) {
    			txt += data[getIndex(i, j, this.cols)] + " ";
		    }
		    txt += "\n";
	    }
	    return txt;
    }
}
