package CustomLinkedList_5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest<T> {
    private static final int INDEX = 0;
    private static final String ELEMENT_1 = "Pesho";
    private static final String ELEMENT_2 = "Gosho";

    private CustomLinkedList<T> customLinkedList;

    @Before
    public void setUp() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowWhenIndexMoreOrEqualThanCount() {
        customLinkedList.get(INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowWhenIndexLessThanZero() {
        customLinkedList.get(-1);
    }

    @Test
    public void testGetReturn() {
        customLinkedList.add((T) ELEMENT_1);

        Assert.assertEquals((T) ELEMENT_1, customLinkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThrowWhenIndexMoreOrEqualThanCount() {
        customLinkedList.set(INDEX, (T) ELEMENT_1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThrowWhenIndexLessThanZero() {
        customLinkedList.set(-1, (T) ELEMENT_1);
    }

    @Test
    public void testSetReturn() {
        customLinkedList.add((T) ELEMENT_1);

        customLinkedList.set(0, (T) ELEMENT_1);

        Assert.assertEquals((T) ELEMENT_1, customLinkedList.get(0));
    }

    @Test
    public void testAddChangeTailWhenHeadNotNull() {
        customLinkedList.add((T) ELEMENT_1);

        customLinkedList.add((T) ELEMENT_2);

        Assert.assertEquals((T) ELEMENT_2, customLinkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowWhenIndexMoreOrEqualThanCount() {
        customLinkedList.removeAt(INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowWhenIndexLessThanZero() {
        customLinkedList.removeAt(-1);
    }

    @Test
    public void testRemoveAtReturn() {
        customLinkedList.add((T) ELEMENT_1);
        customLinkedList.add((T) ELEMENT_2);

        Assert.assertEquals((T) ELEMENT_2, customLinkedList.removeAt(1));
    }

    @Test
    public void testRemoveReturnMinusOneWhenHeadNull() {
        Assert.assertEquals(-1, customLinkedList.remove((T) ELEMENT_1));
    }

    @Test
    public void testRemoveReturnZeroWhenHeadEqualsItem() {
        customLinkedList.add((T) ELEMENT_1);

        Assert.assertEquals(0, customLinkedList.remove((T) ELEMENT_1));
    }

    @Test
    public void testRemoveChangeHeadAndTailCorrect() {
        customLinkedList.add((T) ELEMENT_1);
        customLinkedList.add((T) ELEMENT_2);

        customLinkedList.remove((T) "Toni");

        Assert.assertEquals((T) ELEMENT_2, customLinkedList.get(1));
    }

    @Test
    public void testIndexOfReturnMinusOneWhenHeadNull() {
        Assert.assertEquals(-1, customLinkedList.indexOf((T) ELEMENT_1));
    }

    @Test
    public void testIndexOfReturnZeroWhenHeadEqualsItem() {
        customLinkedList.add((T) ELEMENT_1);

        Assert.assertEquals(0, customLinkedList.indexOf((T) ELEMENT_1));
    }

    @Test
    public void testIndexOfChangeHeadAndTailCorrect() {
        customLinkedList.add((T) ELEMENT_1);
        customLinkedList.add((T) ELEMENT_2);

        customLinkedList.indexOf((T) "Toni");

        Assert.assertEquals((T) ELEMENT_2, customLinkedList.get(1));
    }

    @Test
    public void testContainsReturnFalseWhenHeadNull() {
        Assert.assertFalse(customLinkedList.contains((T) ELEMENT_1));
    }

    @Test
    public void testContainsReturnTrueWhenHeadNotNull() {
        customLinkedList.add((T) ELEMENT_1);

        Assert.assertTrue(customLinkedList.contains((T) ELEMENT_1));
    }
}