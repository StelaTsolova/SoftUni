package IteratorTest_3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private static final String[] ELEMENTS = new String[]{"Siti", "Megi", "Pipi"};
    private static final int INDEX = 2;

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenElementsNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testMoveReturnTrueWhenHasNextIsTrue() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMoveReturnFalseWhenHasNextIsFalse() {
        listIterator.move();
        listIterator.move();

        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextWhenIndexLessThanElementSizeWithoutOne() {
        listIterator.move();

        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextWhenIndexNotMoreLessThanElementSizeWithoutOne() {
        listIterator.move();
        listIterator.move();

        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testPrintCorrect() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(ELEMENTS[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}