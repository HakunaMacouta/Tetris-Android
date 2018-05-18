package blanc.thomas.dawin.tetris.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum TetrominoType {
    I, J, L, O, S, T;

    private static final List<TetrominoType> values =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final Random rand = new Random();

    public static TetrominoType randomTetrominoType() {
        return values.get(rand.nextInt(values.size()));
    }
}
