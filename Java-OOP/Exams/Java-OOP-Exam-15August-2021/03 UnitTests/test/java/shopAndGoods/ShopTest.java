package shopAndGoods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelves() {
        Map<String, Goods> shelves = shop.getShelves();

        shelves.remove("Shelves1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsThrowWhenShelfNotInShelves() throws OperationNotSupportedException {
        shop.addGoods("Pesho", new Goods("Ivan", "45"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsThrowWhenShelfAlreadyInShelves() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", new Goods("Ivan", "45"));

        shop.addGoods("Shelves1", new Goods("Ivan", "45"));
    }

    @Test()
    public void testAddGoodsAddTheCorrect() throws OperationNotSupportedException {
        Goods goods = new Goods("Ivan", "45");
        shop.addGoods("Shelves1", goods);
        Goods shopGoods = shop.getShelves().get("Shelves1");

        Assert.assertEquals(goods.getName(), shopGoods.getName());
        Assert.assertEquals(goods.getGoodsCode(), shopGoods.getGoodsCode());
    }

    @Test()
    public void testAddGoodsReturnTheCorrect() throws OperationNotSupportedException {
        Goods goods = new Goods("Ivan", "45");

        Assert.assertEquals(String.format("Goods: %s is placed successfully!", 45), shop.addGoods("Shelves1", goods));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsThrowWhenGivenGoodsExist() throws OperationNotSupportedException {
        Goods goods = new Goods("Ivan", "45");
        shop.addGoods("Shelves1", goods);

        shop.addGoods("Shelves2", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsThrowWhenShelfNotInShelves() throws OperationNotSupportedException {
        shop.removeGoods("Pesho", new Goods("Ivan", "45"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsThrowWhenGoodsInShelvesNotEqualsGivenGoods() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", new Goods("Ivan", "45"));

        shop.removeGoods("Shelves1", new Goods("Pesho", "47"));
    }

    @Test()
    public void testRemoveGoodsRemoveTheCorrect() throws OperationNotSupportedException {
        Goods goods = new Goods("Ivan", "45");
        shop.addGoods("Shelves1", goods);
        Goods shopGoods = shop.getShelves().get("Shelves1");

        Assert.assertEquals(goods.getName(), shopGoods.getName());
        Assert.assertEquals(goods.getGoodsCode(), shopGoods.getGoodsCode());

        shop.removeGoods("Shelves1", shopGoods);

        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }

    @Test()
    public void testRemoveGoodsReturnTheCorrect() throws OperationNotSupportedException {
        Goods goods = new Goods("Ivan", "45");
        shop.addGoods("Shelves1", goods);
        Goods shopGoods = shop.getShelves().get("Shelves1");

        Assert.assertEquals(goods.getName(), shopGoods.getName());
        Assert.assertEquals(goods.getGoodsCode(), shopGoods.getGoodsCode());

        Assert.assertEquals(String.format("Goods: %s is removed successfully!", "45"), shop.removeGoods("Shelves1", shopGoods));
    }
}