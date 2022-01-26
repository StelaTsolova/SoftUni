package ExtendedDatabase_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person[] ELEMENTS = new Person[]{new Person(12, "Pesho"), new Person(78, "Gosho")};
    private static final int MAX_LIMIT = 16;
    private static final int MIN_LIMIT = 1;
    private static final Person PERSON = new Person(78, "Gosho");
    private static final String FIND_USERNAME = "Titi";

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    @Test
    public void testConstructorCreateValidObject() {
        Person[] databaseElements = database.getElements();
        Assert.assertArrayEquals(ELEMENTS, databaseElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenElementsMoreThanMaxLimit() throws OperationNotSupportedException {
        new Database(new Person[MAX_LIMIT + 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenElementsLessThanMinLimit() throws OperationNotSupportedException {
        new Database(new Person[MIN_LIMIT - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowWhenElementNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(PERSON);
        Person[] currentElement = new Person[]{new Person(12, "Pesho"), new Person(78, "Gosho"), PERSON};

        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(currentElement[i].getId(), database.getElements()[i].getId());
            Assert.assertEquals(currentElement[i].getUsername(), database.getElements()[i].getUsername());
        }
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
        Person[] databaseElements = database.getElements();

        Assert.assertEquals(ELEMENTS[ELEMENTS.length - 2].getId(), databaseElements[databaseElements.length - 1].getId());
        Assert.assertEquals(ELEMENTS[ELEMENTS.length - 2].getUsername(), databaseElements[databaseElements.length - 1].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenUsernameNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWhenElementsEmpty() throws OperationNotSupportedException {
        database.remove();
        database.remove();

        database.findByUsername(PERSON.getUsername());
    }

    @Test
    public void testFindByUsernameShouldReturnPerson() throws OperationNotSupportedException {
        Person findPerson = database.findByUsername(ELEMENTS[1].getUsername());

        Assert.assertEquals(ELEMENTS[1].getId(), findPerson.getId());
        Assert.assertEquals(ELEMENTS[1].getUsername(), findPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowWhenElementsEmpty() throws OperationNotSupportedException {
        database.remove();
        database.remove();

        database.findById(PERSON.getId());
    }

    @Test
    public void testFindByIdShouldReturnId() throws OperationNotSupportedException {
        Person findPerson = database.findById(ELEMENTS[1].getId());

        Assert.assertEquals(ELEMENTS[1].getId(), findPerson.getId());
        Assert.assertEquals(ELEMENTS[1].getUsername(), findPerson.getUsername());
    }
}