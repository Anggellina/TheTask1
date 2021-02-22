import java.util.Arrays;

public class Field {

    private final int size;
    private SYMBOL[][] field;

    public enum SYMBOL {
        X, O, empty
    }

    public Field(int n) {
        size = n;
        field = new SYMBOL[size][size];
        for (SYMBOL[] array : field) {
            Arrays.fill(array, SYMBOL.empty);
        }
    }

    public void addX(int x, int y) {
        checkModify(x, y);
        field[y][x] = SYMBOL.X;
    }

    public void addO(int x, int y) {
        checkModify(x, y);
        field[y][x] = SYMBOL.O;
    }

    public void remove(int x, int y) {
        checkModify(x, y);
        field[y][x] = SYMBOL.empty;
    }

    private void checkModify(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) throw new IndexOutOfBoundsException();
    }

    public int findMaxSequence(SYMBOL sign) {
        int result = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (field[y][x] == sign) {
                    int current = 1;
                    int x1 = x - 1;
                    while (x1 >= 0) {
                        if (field[y][x1] == sign) {
                            current++;
                            x1--;
                        } else {
                            break;
                        }
                    }
                    if (current > result) result = current;
                    current = 1;
                    int y1 = y - 1;
                    while (y1 >= 0) {
                        if (field[y1][x] == sign) {
                            current++;
                            y1--;
                        } else {
                            break;
                        }
                    }
                    if (current > result) result = current;
                    current = 1;
                    x1 = x - 1;
                    y1 = y - 1;
                    while (x1 >= 0 && y1 >= 0) {
                        if (field[y1][x1] == sign) {
                            current++;
                            x1--;
                            y1--;
                        } else {
                            break;
                        }
                    }
                    if (current > result) result = current;
                    current = 1;
                    x1 = x - 1;
                    y1 = y + 1;
                    while (x1 >= 0 && y1 < size) {
                        if (field[y1][x1] == sign) {
                            current++;
                            x1--;
                            y1++;
                        } else {
                            break;
                        }
                    }
                    if (current > result) result = current;
                }
            }
        }
        return result;
    }


    public SYMBOL[][] getField() {
        return field;
    }

    public void setField(SYMBOL[][] array) {
        field = array;
    }
}