package rpg_lab;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeroTest {
    private static final String HERO_NAME = "Java";
    private static final int TARGET_EXPERIENCE = 100;
    private static final int AXE_ATTACK = 20;
    private static final int AXE_DURABILITY = 30;


    private Weapon weapon;
    private Hero hero;
    private Target target;

    @Before
    public void setUp() {
        weapon = Mockito.mock(Weapon.class);
        hero = new Hero(HERO_NAME, weapon);
        target = Mockito.mock(Target.class);
    }

    @Test
    public void testHeroGainsExperienceWhenTargetDies() {
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_EXPERIENCE);

        hero.attack(target);

        assertEquals(TARGET_EXPERIENCE, hero.getExperience());
    }

    @Test
    public void testWhenHeroKillsTargetInventoryShouldAddNewLoot() {
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.getLoot()).thenReturn(new Axe(AXE_ATTACK, AXE_DURABILITY));

        hero.attack(target);

        List<Weapon> inventory = hero.getInventory();

        assertEquals(1, inventory.size());
        Weapon loot = inventory.get(0);
        assertEquals(AXE_ATTACK, loot.getAttackPoints());
        assertEquals(AXE_DURABILITY, loot.getDurabilityPoints());
    }
}