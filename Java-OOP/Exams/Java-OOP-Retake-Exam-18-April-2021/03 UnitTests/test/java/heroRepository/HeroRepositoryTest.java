package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTest {

    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void testGetCountShouldReturnHeroRepositorySize() {
        Assert.assertEquals(0, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowWhenGivenHeroIsNull() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrowWhenExistHeroWhitSameName() {
        heroRepository.create(new Hero("Pesho", 3));

        heroRepository.create(new Hero("Pesho", 4));
    }

//    @Test
//    public void testCreateShouldAddHeroTheCorrect(){
//        heroRepository.create(new Hero("Pesho", 3));
//
////        Assert.assertEquals(heroRepository.g);
//    }

    @Test
    public void testCreateShouldReturnMessage() {
        Assert.assertEquals(String.format("Successfully added hero %s with level %d","Pesho", 3 ),
                heroRepository.create(new Hero("Pesho", 3)));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrowWhenNameIsNullOrEmpty(){
        heroRepository.remove(null);
    }

    @Test
    public void testRemoveShouldReturnTrueWhenHeroNameIsRepository(){
        heroRepository.create(new Hero("Pesho", 3));

        Assert.assertTrue(heroRepository.remove("Pesho"));
    }

    @Test
    public void testRemoveShouldReturnFalseWhenHeroNameNotIsRepository(){
        Assert.assertFalse(heroRepository.remove("Pesho"));
    }

    @Test
    public void testGetHeroWithHighestLevelShouldReturnHeroWhitMaxLevel(){
        heroRepository.create(new Hero("Pesho", 3));
        heroRepository.create(new Hero("Moni", 15));
        heroRepository.create(new Hero("Ivo",7 ));

        Assert.assertEquals("Moni", heroRepository.getHeroWithHighestLevel().getName());
        Assert.assertEquals(15, heroRepository.getHeroWithHighestLevel().getLevel());
    }

    @Test
    public void testGetHeroShouldReturnTheCorrectHero(){
        heroRepository.create(new Hero("Pesho", 3));

        Assert.assertEquals("Pesho", heroRepository.getHero("Pesho").getName());
        Assert.assertEquals(3, heroRepository.getHero("Pesho").getLevel());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroes(){
        heroRepository.getHeroes().remove(new Hero("Pesho", 3));
    }
}