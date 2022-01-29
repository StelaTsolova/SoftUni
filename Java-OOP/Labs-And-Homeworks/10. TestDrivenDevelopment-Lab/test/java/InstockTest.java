import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class InstockTest {
    private static final String LABEL_ONE = "bread";
    private static final double PRICE_ONE = 1.65;
    private static final int QUANTITY_ONE = 15;

    private ProductStock stock;
    private Product productOne;
    private Product productTwo;
    private Product productThree;

    @Before
    public void setUp() {
        stock = new Instock();
        productOne = new Product(LABEL_ONE, PRICE_ONE, QUANTITY_ONE);
        productTwo = new Product("popcorn", 3.66, 86);
        productThree = new Product("milk", 3.00, 6);
    }

    @Test
    public void testAddShouldAddTheProduct() {
        stock.add(productOne);
        Assert.assertTrue(stock.contains(productOne));
    }

    @Test
    public void testAddShouldNotAddTheSameProductSecondTime() {
        stock.add(productOne);
        stock.add(productOne);

        Assert.assertEquals(1, stock.getCount());
    }

    @Test
    public void testContainsReturnFalseWhenProductNotPresentAndReturnTrueAfterAdded() {
        Assert.assertFalse(stock.contains(productOne));

        stock.add(productOne);

        Assert.assertTrue(stock.contains(productOne));
    }

    @Test
    public void testGetCountShouldReturnNumberOfProduct() {
        stock.add(productOne);

        Assert.assertEquals(1, stock.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowWhenIndexLessThanZero() {
        stubProducts();

        stock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowWhenIndexMoreThanStockSize() {
        stubProducts();

        stock.find(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowWhenStockIsEmpty() {
        stock.find(5);
    }

    @Test
    public void testFindReturnCorrectProduct() {
        stubProducts();

        Assert.assertNotNull(stock.find(2));
        Assert.assertEquals("potato", stock.find(2).getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityThrowWhenProductNotInStock() {
        stubProducts();

        stock.changeQuantity(LABEL_ONE, 63);
    }

    @Test
    public void testChangeQuantityShouldChangeQuantityCorrect() {
        stock.add(productOne);
        stock.changeQuantity(LABEL_ONE, 13);

        Assert.assertNotNull(stock.findByLabel(LABEL_ONE));
        Assert.assertEquals(13, stock.findByLabel(LABEL_ONE).getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelThrowWhenProductNotInStock() {
        stubProducts();

        stock.findByLabel(LABEL_ONE);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnGivenNumberProducts() {
        stubProducts();

        List<Product> listFromIterable = createListFromIterable(stock.findFirstByAlphabeticalOrder(3));

        Assert.assertEquals(3, listFromIterable.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnEmptyCollectionWhenStockIsEmpty() {
        List<Product> listFromIterable = createListFromIterable(stock.findFirstByAlphabeticalOrder(1));

        Assert.assertTrue(listFromIterable.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnEmptyCollectionWhenParameterTooLarge() {
        stubProducts();

        List<Product> listFromIterable = createListFromIterable(stock.findFirstByAlphabeticalOrder(5));

        Assert.assertTrue(listFromIterable.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnTheObjectSorted() {
        List<String> sortedProducts = stubProducts().stream().map(Product::getLabel)
                .sorted().collect(Collectors.toList());

        List<Product> listFromIterable = createListFromIterable(stock.findFirstByAlphabeticalOrder(3));

        for (int i = 0; i < listFromIterable.size(); i++) {
            Assert.assertEquals(sortedProducts.get(i), listFromIterable.get(i).getLabel());
        }
    }

    @Test
    public void testFindAllInRangeReturnEmptyCollectionWhenStockIsEmpty() {
        List<Product> listFromIterable = createListFromIterable(stock.findAllInRange(12.4, 17.2));

        Assert.assertTrue(listFromIterable.isEmpty());
    }

    @Test
    public void testFindAllInRangeReturnTheObjectCorrect() {
        stubProducts();

        List<Product> listFromIterable = createListFromIterable(stock.findAllInRange(1.20, 2.30));

        Assert.assertEquals(2, listFromIterable.size());
    }

    @Test
    public void testFindAllInRangeReturnTheObjectSorted() {
        stubProducts();

        List<Product> listFromIterable = createListFromIterable(stock.findAllInRange(1.20, 2.30));
        List<Double> sortedProducts = listFromIterable.stream().mapToDouble(Product::getPrice)
                .boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < listFromIterable.size(); i++) {
            Assert.assertEquals(sortedProducts.get(i), listFromIterable.get(i).getPrice(), 0.0);
        }
    }

    @Test
    public void testFindAllByPriceReturnEmptyCollectionWhenStockIsEmpty() {
        List<Product> listFromIterable = createListFromIterable(stock.findAllByPrice(PRICE_ONE));

        Assert.assertTrue(listFromIterable.isEmpty());
    }

    @Test
    public void testFindAllByPriceReturnTheObjectCorrect() {
        stubProducts();

        List<Product> listFromIterable = createListFromIterable(stock.findAllByPrice(36.00));

        Assert.assertEquals(1, listFromIterable.size());
    }

    @Test
    public void testFindFirstMostExpensiveProductsReturnGivenCountProducts() {
        List<Double> sortedProducts = stubProducts().stream().mapToDouble(Product::getPrice)
                .boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<Product> listFromIterable = createListFromIterable(stock.findFirstMostExpensiveProducts(3));

        for (int i = 0; i < listFromIterable.size(); i++) {
            Assert.assertEquals(sortedProducts.get(i), listFromIterable.get(i).getPrice(), 0.0);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsThrowWhenStockSizeLessThanGivenCountProducts() {
        stubProducts();

        stock.findFirstMostExpensiveProducts(5);
    }

    @Test
    public void testFindAllByQuantityReturnEmptyCollectionWhenStockIsEmpty() {
        List<Product> listFromIterable = createListFromIterable(stock.findAllByQuantity(QUANTITY_ONE));

        Assert.assertTrue(listFromIterable.isEmpty());
    }

    @Test
    public void testFindAllByQuantityReturnTheObjectCorrect() {
        stubProducts();

        List<Product> listFromIterable = createListFromIterable(stock.findAllByQuantity(17));

        Assert.assertEquals(1, listFromIterable.size());
    }

    @Test
    public void testIteratorReturnAllProductInStock() {
        List<Product> products = stubProducts();

        Iterator<Product> iterator = stock.iterator();
        Assert.assertNotNull(iterator);

        int index = 0;
        while (iterator.hasNext()) {
            Product product = iterator.next();
            Assert.assertEquals(products.get(index++).getLabel(), product.getLabel());
        }
    }

    private List<Product> stubProducts() {
        List<Product> products = Arrays.asList(
                new Product("cola", 2.30, 5),
                new Product("apple", 1.30, 17),
                new Product("potato", 1.20, 30),
                new Product("cake", 36.00, 2));

        for (Product product : products) {
            stock.add(product);
        }
        return products;
    }

    private List<Product> createListFromIterable(Iterable<Product> iterable) {
        Assert.assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);

        return products;
    }
}