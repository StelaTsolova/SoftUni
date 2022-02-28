package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTest {
    private static final String NAME = "Live";
    private static final int CAPACITY = 2;

    private House house;

    @Before
    public void setUp() {
        this.house = new House(NAME, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowWhenNameIsNullOrEmpty() {
        House house = new House(" ", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowWhenCapacityLessThanZero() {
        House house = new House(NAME, -1);
    }

    @Test
    public void testConstructorCreativeTheCorrectObject() {
        Assert.assertEquals(NAME, house.getName());
        Assert.assertEquals(CAPACITY, house.getCapacity());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowWhenHouseIsFull() {
        house.addCat(new Cat("Mimi"));
        house.addCat(new Cat("Tony"));

        house.addCat(new Cat("Pesho"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrowWhenCatNotPresent() {
        house.removeCat("mimi");
    }

    @Test
    public void testRemoveCat() {
        house.addCat(new Cat("Mimi"));
        Assert.assertEquals(1, house.getCount());

        house.removeCat("Mimi");
        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowWhenCatNotPresent() {
        house.catForSale("mimi");
    }

    @Test
    public void testCatForSale() {
        house.addCat(new Cat("Mimi"));

        Assert.assertEquals("Mimi", house.catForSale("Mimi").getName());
    }

    @Test
    public void testStatistics() {
        house.addCat(new Cat("Mimi"));

        Assert.assertEquals("The cat Mimi is in the house Live!", house.statistics());
    }

    @Test
    public void testIsHungry(){
        Cat mimi = new Cat("Mimi");
        house.addCat(mimi);
        Assert.assertTrue(mimi.isHungry());

        house.catForSale("Mimi");
        Assert.assertFalse(mimi.isHungry());

    }
}