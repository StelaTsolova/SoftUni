package Database_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer[] ELEMENTS = new Integer[]{15, 3, 7, 96, 83};
    private static final int MAX_LIMIT = 16;
    private static final int MIN_LIMIT = 1;
    private static final Integer INTEGER = 6;

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    @Test
    public void testConstructorCreateValidObject() {
        Integer[] databaseElements = database.getElements();
        Assert.assertArrayEquals(ELEMENTS, databaseElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenElementsMoreThanMaxLimit() throws OperationNotSupportedException {
        new Database(new Integer[MAX_LIMIT + 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenElementsLessThanMinLimit() throws OperationNotSupportedException {
        new Database(new Integer[MIN_LIMIT - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowWhenElementNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(INTEGER);
        Integer[] currentElement = new Integer[]{15, 3, 7, 96, 83, INTEGER};

        Assert.assertArrayEquals(currentElement, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowWhenArrayEmpty() throws OperationNotSupportedException {
        for (int i = 0; i < ELEMENTS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveShouldLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] databaseElements = database.getElements();

        Assert.assertEquals(ELEMENTS[ELEMENTS.length - 2], databaseElements[databaseElements.length - 1]);
    }
}