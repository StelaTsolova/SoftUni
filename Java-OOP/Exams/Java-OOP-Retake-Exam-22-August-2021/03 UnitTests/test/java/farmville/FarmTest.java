package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmTest {
    private static final String NAME = "Pesho";
    private static final int CAPACITY = 2;

    private Farm farm;

    @Before
    public void setUp(){
        this.farm = new Farm(NAME, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowNameIsNullOrEmpty(){
        Farm farm = new Farm("", 15);
    }

    @Test()
    public void testConstructorThrowCapacityLassThanZero(){
        Assert.assertEquals(NAME, farm.getName());
        Assert.assertEquals(CAPACITY, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorCreateObjectTheCorrect(){
        Farm farm = new Farm("Vili", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowWhenCapacityIsFull(){
        Animal animal = new Animal("Cat", 14.2);
        Animal animal1 = new Animal("Mouse", 2.3);
        farm.add(animal);
        farm.add(animal1);

        Animal animal2 = new Animal("Dog", 25.7);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowWhenAnimalTypeIsPresent(){
        Animal animal = new Animal("Cat", 14.2);
        farm.add(animal);

        Animal animal1 = new Animal("Cat", 2.3);
        farm.add(animal1);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testAddShouldAddTheCorrect(){
//        Animal animal = new Animal("Cat", 14.2);
//        farm.add(animal);
//
//        Assert.assertEquals("Cat", farm.ge);
//    }

    @Test
    public void testRemoveShouldReturnTrueWhenAnimalTypeIsPresent(){
        Animal animal = new Animal("Cat", 14.2);
        farm.add(animal);

        Assert.assertTrue(farm.remove("Cat"));
    }

    @Test
    public void testRemoveShouldReturnFauseWhenAnimalTypeNotPresent(){
        Assert.assertFalse(farm.remove("Cat"));
    }
}