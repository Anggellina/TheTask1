import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    int n = 3;
    Field ttf = new Field(n);

    @Test
    void addX() {
        Field.SYMBOL[][] expected = {
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.X, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty}};
        ttf.addX(1, 1);
        for (int i = 0; i < n; i++) {
            assertTrue(Arrays.equals(expected[i], ttf.getField()[i]));
        }

        ttf.addX(1,1);
        for (int i = 0; i < n; i++) {
            assertTrue(Arrays.equals(expected[i], ttf.getField()[i]));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> ttf.addX(4, 5));
    }

    @Test
    void addO() {
        Field.SYMBOL[][] expected = {
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.O, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty}};
        ttf.addO(1, 1);
        for (int i = 0; i < n; i++) {
            assertTrue(Arrays.equals(expected[i], ttf.getField()[i]));
        }

        ttf.addO(1,1);
        for (int i = 0; i < n; i++) {
            assertTrue(Arrays.equals(expected[i], ttf.getField()[i]));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> ttf.addO(-1, -1));
    }

    @Test
    void remove() {
        Field.SYMBOL[][] expected = {
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty}};
        ttf.addX(1, 1);
        ttf.remove(1, 1);
        for (int i = 0; i < n; i++) {
            assertTrue(Arrays.equals(expected[i], ttf.getField()[i]));
        }

        ttf.remove(1,1);
        for (int i = 0; i < n; i++) {
            assertTrue(Arrays.equals(expected[i], ttf.getField()[i]));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> ttf.remove(4, 5));
    }

    @Test
    void findMaxSequence() {
        Field.SYMBOL[][] horizontal = {
                {Field.SYMBOL.X, Field.SYMBOL.X, Field.SYMBOL.X},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty}};
        ttf.setField(horizontal);
        assertEquals(3, ttf.findMaxSequence(Field.SYMBOL.X));

        Field.SYMBOL[][] vertical = {
                {Field.SYMBOL.X, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.X, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.X, Field.SYMBOL.empty, Field.SYMBOL.empty}};
        ttf.setField(vertical);
        assertEquals(3, ttf.findMaxSequence(Field.SYMBOL.X));

        Field.SYMBOL[][] diagonal = {
                {Field.SYMBOL.X, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.X, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.X}};
        ttf.setField(diagonal);
        assertEquals(3, ttf.findMaxSequence(Field.SYMBOL.X));

        Field.SYMBOL[][] antiDiagonal = {
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.X},
                {Field.SYMBOL.empty, Field.SYMBOL.X, Field.SYMBOL.empty},
                {Field.SYMBOL.X, Field.SYMBOL.empty, Field.SYMBOL.empty}};
        ttf.setField(antiDiagonal);
        assertEquals(3, ttf.findMaxSequence(Field.SYMBOL.X));

        Field.SYMBOL[][] empty = {
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.empty}};
        ttf.setField(empty);
        assertEquals(0, ttf.findMaxSequence(Field.SYMBOL.X));

        Field.SYMBOL[][] field = {
                {Field.SYMBOL.X, Field.SYMBOL.empty, Field.SYMBOL.X},
                {Field.SYMBOL.X, Field.SYMBOL.empty, Field.SYMBOL.X},
                {Field.SYMBOL.empty, Field.SYMBOL.empty, Field.SYMBOL.X}};
        ttf.setField(field);
        assertEquals(3, ttf.findMaxSequence(Field.SYMBOL.X));

        Field.SYMBOL[][] full = {
                {Field.SYMBOL.X, Field.SYMBOL.X, Field.SYMBOL.X},
                {Field.SYMBOL.X, Field.SYMBOL.X, Field.SYMBOL.X},
                {Field.SYMBOL.X, Field.SYMBOL.X, Field.SYMBOL.X}};
        ttf.setField(full);
        assertEquals(3, ttf.findMaxSequence(Field.SYMBOL.X));
    }
}